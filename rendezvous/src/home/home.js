import React, { Component } from 'react';
import { DatePickerIOS, View, TextInput, Image, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
const { height, width } = Dimensions.get('window');


export default class Home extends Component<{}> {
  constructor(props) {
    super(props);
    let newDate = (new Date).getHours() + `:${(new Date).getMinutes()}`
    this.state = {
      timePickerOffest: height,
      time: new Date(),
    }
  }


  sendInfo() {
    this.props.navigation.navigate('TripSelect')
  }

  toggleTimePicker() {
    this.state.timePickerOffest == 0 ?
    this.setState({
      timePickerOffest: height
    }) :
    this.setState({
      timePickerOffest: 0
    })
  }


  render() {
    return (
      <View style={styles.wrapper}>
        <Image
          style={styles.background}
          blurRadius={2}
          source={require('../../map.png')}
        />
        <View style={styles.filter}/>
        <View style={styles.inputWrapper}>
          <Text style={styles.text}>Where do you want to go?</Text>
          <TextInput style={styles.input} placeholder="Train or Bus" />
        </View>
        <View style={styles.inputWrapper}>
          <Text style={styles.text}>What time do you want to leave?</Text>
          <TouchableOpacity style={{backgroundColor: 'rgba(255,255,255,.5)', borderRadius: 10}} onPress={this.toggleTimePicker.bind(this)}>
            <Text style={[styles.input, {backgroundColor: 'transparent'}]}>
              {this.state.time.getHours()}:{this.state.time.getMinutes()}
            </Text>
          </TouchableOpacity>
        </View>
        <TouchableOpacity onPress={this.sendInfo.bind(this)} style={styles.nextButton}>
          <Text style={{color: '#e0e0e0'}}>
            BEAM ME UP!
          </Text>
        </TouchableOpacity>
        <View style={{
            position: 'absolute',
            bottom: this.state.timePickerOffest,
          }}>
          <DatePickerIOS
            style={{
              width,
              backgroundColor: 'rgba(255,255,255,.95)'
            }}
            onDateChange={(time)=>{ this.setState({time: time})}}
            mode='time'
            minimumDate={new Date()}
            date={this.state.time}
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
            <Text>Done</Text>
          </TouchableOpacity>
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
    backgroundColor: 'rgba(0,188,212,.8)',
    // backgroundColor: 'rgba(13,71,161,.7)'
  },
  text: {
    color: 'white',
    fontSize: 14,
    fontWeight: 'bold',
    marginBottom: 5
    // textAlign: 'left',
  },
  input: {
    backgroundColor: 'rgba(255,255,255,.5)',
    padding: 10,
    borderRadius: 10,
    width: width * .8,
    overflow: 'hidden'
  },
  nextButton: {
    position: 'absolute',
    bottom: 100,
    padding: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: 'rgba(42,42,42,1)',
    borderRadius: 10
  },

})
