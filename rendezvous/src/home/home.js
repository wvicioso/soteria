import React, { Component } from 'react';
import { DatePickerIOS, View, TextInput, Image, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
const { height, width } = Dimensions.get('window');


export default class Home extends Component<{}> {
  constructor(props) {
    super(props);
    let newDate = (new Date).getHours() + `:${(new Date).getMinutes()}`
    this.state = {
      timePickerOffest: height,
      trainPickerOffest: height,
      time: '',
      train: '',
      trainObj: '',
      userLat: '',
      userLng: '',
      trainsArr: [],
      meetupsArr: [],
      schoolId: ''
    }
  }

  componentDidMount() {
    this.setState({
      email: this.props.navigation.state.params.email
    })
    this.getSchools();
    this.getLocation();
    this.getTrips();
  }

  getMeetup() {
    let { schoolId } = this.state
    let meetups = [];
    fetch('https://rendezvous.mybluemix.net/meetups', {
      method: 'get',
      headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then((responseJson) => {
      for (var i = 0; i < responseJson.length; i++) {
        if (responseJson[i].school == schoolId) {
          meetups.push(responseJson[i]);
        }
      }
      this.setState({
        meetupsArr: meetups
      })
      // alert('Rendezvous Infront of main campus');
    });
  }

  getTrains() {
    let { schoolId } = this.state
    let trains = [];
    fetch('https://rendezvous.mybluemix.net/destinations', {
      method: 'get',
      headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then((responseJson) => {
      for (var i = 0; i < responseJson.length; i++) {
        if (responseJson[i].school == schoolId) {
          trains.push(responseJson[i]);
        }
      }
      this.setState({
        trainsArr: trains
      })
      // alert('Rendezvous Infront of main campus');
    });
  }

  getSchools() {
    let email = this.props.navigation.state.params.email.split('@')[1]
    fetch('https://rendezvous.mybluemix.net/schools', {
      method: 'get',
      headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then((responseJson) => {
      for (var i = 0; i < responseJson.length; i++) {
        if (responseJson[i].domain == email) {
          this.setState({
            schoolId: responseJson[i].id
          })
          this.getMeetup();
          this.getTrains();
        }
      }
      // alert('Rendezvous Infront of main campus');
    });
    // this.props.navigation.navigate('TripSelect');
  }



  getLocation() {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        this.setState({
          userLat: position.coords.latitude,
          userLng: position.coords.longitude
        })
        this.getUserCount();
      },
      (error) => console.log(error.message),
      {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
    )
  }


  getTrips() {
    let response = '';
    let _this = this;

    fetch('https://rendezvous.mybluemix.net/trips', {
      method: 'get',
      headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then((responseJson) => {
      this.setState({
        tripsArr: responseJson
      })
      // alert('Rendezvous Infront of main campus');
    });
    // this.props.navigation.navigate('TripSelect');
  }

  toggleTrainSelection() {
    if (this.state.timePickerOffest == 0) { this.toggleTimePicker() }
    this.state.trainPickerOffest == 0 ?
    this.setState({
      trainPickerOffest: height
    }) :
    this.setState({
      trainPickerOffest: 0
    })
  }

  toggleTimePicker() {
    if (this.state.trainPickerOffest == 0) { this.toggleTrainSelection() }
    this.state.timePickerOffest == 0 ?
    this.setState({
      timePickerOffest: height
    }) :
    this.setState({
      timePickerOffest: 0
    })
  }

  formatTime() {
    let hours = this.state.time.getHours(),
        minutes = this.state.time.getMinutes(),
        result = '',
        dayNight = 'AM'

    if (hours > 12) {
      result += `${hours - 12}`;
      dayNight = 'PM'
    } else if (hours == 12) {
      result += `${hours}`;
      dayNight = 'PM';
    } else {
      result += `${hours}`;
    }

    result += `:${minutes}`;

    if (minutes.toString().length == 1) {
      result += `0`;
    }

    return result += ` ${dayNight}`
  }

  setTrain(train) {
    this.setState({
      trainObj: train,
      train: `${train.train_stop} - ${train.trains} Train`
    })
    this.toggleTrainSelection();
  }

  renderTrains() {
    let items = [],
        { trainsArr } = this.state
    if (trainsArr.length == 0) {
      return (<View/>)
    } else {
      for (var i = 0; i < trainsArr.length; i++) {
        items.push(<TouchableOpacity onPress={this.setTrain.bind(this, trainsArr[i])} style={styles.trainCard}>
          <Text style={styles.trainText}>{trainsArr[i].trains}</Text>
          <Text style={{fontSize: 17, color: 'rgba(255,255,255,.5)'}}>{trainsArr[i].train_stop}</Text>
        </TouchableOpacity>)
      }
    }
    return items;
  }

  checkInfo() {
    for (var i = 0; i < this.state.tripsArr.length; i++) {
      let trip = this.state.tripsArr[i]
      if (trip.destination == this.state.trainObj.id &&
          new Date(trip.time).toJSON() == new Date(this.state.time.toString().slice(0, 21) + `:00 GMT-0000 (EDT)`).toJSON() &&
          trip.meetup == this.state.meetupsArr[0].id) {
      }
      this.sendInfo(trip);
    }
  }

  sendInfo(trip) {
    fetch(`https://rendezvous.mybluemix.net/trips/${trip.id}/`, {
      method: 'put',
      headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify({
        destination: this.state.trainObj.id,
        meetup: this.state.meetupsArr[0].id,
        users: [1, 8]
      }),
    })
    .then(response => response.json())
    .then((responseJson) => {
      this.setState({
        updatedTrip: responseJson
      })
      alert(`You have been added to the trip leave at ${this.formatTime()}. View`)
    });
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <Image
          style={styles.background}
          // blurRadius={2}
          source={require('../../outline.jpg')}
        />
        <View style={styles.filter}/>
        <View style={styles.inputWrapper}>
          <Text style={styles.text}>Where do you want to go?</Text>
          <TouchableOpacity
            style={styles.timeBtn}
            onPress={this.toggleTrainSelection.bind(this)}
            >
            <Text style={styles.input}>
              {
                this.state.train ?
                this.state.train :
                'Train Selection'
              }
            </Text>
          </TouchableOpacity>
        </View>
        <View style={styles.inputWrapper}>
          <Text style={styles.text}>What time do you want to leave?</Text>
          <TouchableOpacity
            style={styles.timeBtn}
            onPress={this.toggleTimePicker.bind(this)}
            >
            <Text style={styles.input}>
              {
                this.state.time ?
                this.formatTime() :
                'Time Selection'
              }
            </Text>
          </TouchableOpacity>
        </View>
        <TouchableOpacity onPress={this.checkInfo.bind(this)} style={styles.nextButton}>
          <Text style={{color: '#e0e0e0'}}>
            BEAM ME UP!
          </Text>
        </TouchableOpacity>
        <View
          style={{
            position: 'absolute',
            bottom: this.state.timePickerOffest,
          }}>
          <DatePickerIOS
            style={{
              width,
              backgroundColor: 'rgba(255,255,255,.95)',
            }}
            onDateChange={(time)=>{ this.setState({time: time})}}
            mode='time'
            minimumDate={new Date()}
            date={this.state.time ? this.state.time : new Date() }
            minuteInterval={15}
          />
          <TouchableOpacity
            onPress={this.toggleTimePicker.bind(this)}
            style={{
              position: 'absolute',
              top: 10,
              right: 10
            }}
          >
            <Text style={styles.done}>Done</Text>
          </TouchableOpacity>
        </View>
        <Image
          style={styles.logo}
          source={require('../../logo-final.png')}
        />
        <View style={[styles.trains, {bottom: this.state.trainPickerOffest}]}>
          { this.renderTrains() }
          <TouchableOpacity
            onPress={this.toggleTrainSelection.bind(this)}
            style={{
              position: 'absolute',
              top: 90,
              right: 20
            }}
          >
            <Text style={styles.done}>Done</Text>
          </TouchableOpacity>
          <Text style={styles.selectTrainText}>Select your train stop destination</Text>
        </View>
      </View>
    );
  }
}

let styles = StyleSheet.create({
  wrapper: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },
  inputWrapper: {
    alignItems: 'flex-start',
    justifyContent: 'space-between',
    margin: 10,
    width: width * .8,
  },
  background: {
    position: 'absolute',
    height,
    width,
    resizeMode: 'cover'
  },
  filter: {
    position: 'absolute',
    height,
    width,
    backgroundColor: 'rgba(0,188,212,.95)'
  },
  text: {
    color: 'white',
    fontSize: 14,
    fontWeight: 'bold',
    marginBottom: 5
    // textAlign: 'left',
  },
  input: {
    fontSize: 17,
    // fontWeight: '500',
    // color: '#424242'
  },
  nextButton: {
    position: 'absolute',
    bottom: 100,
    backgroundColor: 'rgba(42,42,42,1)',
    padding: 15,
    paddingRight: 105,
    paddingLeft: 105,
    borderRadius: 25
  },
  timeBtn: {
    backgroundColor: 'rgba(255,255,255,.7)',
    borderRadius: 10,
    alignItems: 'center',
    justifyContent:'center',
    width: width * .8,
    padding: 10,
  },
  trainCard: {
    width: width * .3,
    height: width * .3,
    backgroundColor: 'rgba(0,188,212,1)',
    margin: 5,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10
  },
  trainText: {
    fontSize: 42,
    color: 'white',
    fontWeight: 'bold'
  },
  trains: {
    position: 'absolute',
    width,
    left: 0,
    height: height,
    backgroundColor: 'rgba(0,0,0,.9)',
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    alignItems: 'center'
  },
  selectTrainText: {
    position: 'absolute',
    top: 220,
    color: 'white',
    fontWeight: 'bold',
    fontSize: 15
  },
  blur: {
    marginLeft:  -32.5,
    backgroundColor: 'transparent',
    position: 'absolute',
    width,
    height,
    resizeMode: 'stretch'
  },
  done: {
    color: 'white',
    fontWeight: 'normal',
    color: 'rgba(0,188,212,1)',
    fontSize: 17
  },
  logo: {
    position: 'absolute',
    top: 40,
    width,
    height: 150,
    resizeMode: 'contain'
  },
})
