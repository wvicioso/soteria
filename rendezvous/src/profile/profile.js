import React, { Component } from 'react';
import { Image, View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
const { height, width } = Dimensions.get('window');

export default class Profile extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      firstName: 'First',
      lastName: 'Last',
      arrivalOffset: height,
      totalUsers: 2
    }
  }

  toggleArrival() {
    this.state.arrivalOffset == height ?
    this.setState({ arrivalOffset: 0, }):
    this.setState({ arrivalOffset: height, totalUsers: 3 })
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <Image
          style={styles.logo}
          source={require('../../logo-final.png')}
        />
        <Text style={styles.top}>
          Wellington Vicioso
        </Text>

        <Image
          style={styles.profileImg}
          source={require('../../user.png')}
        />

        <View style={styles.right}>
          <Text style={styles.title}>Time</Text>
          <Text style={styles.content}>4:00PM</Text>
        </View>

        <View style={styles.left}>
          <Text style={styles.title}>Group Size</Text>
          <Text style={styles.content}>6</Text>
        </View>

        <View style={styles.bottom}>
          <Text style={styles.title}>Destination</Text>
          <View style={styles.trainWrapper}>
            <Text style={styles.train}>6 Train</Text>
          </View>
        </View>

        <TouchableOpacity activeOpacity={1} onPress={this.toggleArrival.bind(this)} style={styles.arrivalCounter}>
          <Text style={styles.counter}>{this.state.totalUsers} / 6</Text>
          <Text style={styles.counterText}>people have arrived</Text>
        </TouchableOpacity>

        <TouchableOpacity activeOpacity={.9} onPress={this.toggleArrival.bind(this)} style={[styles.alertModal, {top: this.state.arrivalOffset}]}>
          <Text style={styles.arriveName}>Mofizur Rhman</Text>
          <View style={styles.alertModalCard}>
            <Image
              style={styles.pattern}
              // blurRadius={2}
              source={require('../../blue.png')}
            />
            <Image
              style={styles.arrivedUserImg}
              source={require('../../Mofi.jpeg')}
            />
          </View>
          <Text style={styles.arriveText}>has arrived!</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

let styles = StyleSheet.create({
  wrapper: {
    flex: 1,
    justifyContent: 'flex-start',
    paddingTop: 90,
    alignItems: 'center',
    backgroundColor: 'rgba(0,188,212,1)',
  },
  profileImg: {
    height: 120,
    width: 120,
    borderRadius: 60
  },
  top: {
    marginBottom: 10,
    justifyContent: 'center',
    alignItems: 'center',
    fontSize: 21,
    fontWeight: 'bold',
    color: 'white'
  },
  bottom: {
    marginTop: 10,
    justifyContent: 'center',
    alignItems: 'center',
  },
  right: {
    alignSelf: 'center',
    right: 20,
    top: 170,
    position: 'absolute',
    justifyContent: 'center',
    alignItems: 'center',
  },
  left: {
    left: 20,
    top: 170,
    alignSelf: 'center',
    position: 'absolute',
    justifyContent: 'center',
    alignItems: 'center',
  },
  name: {
    fontWeight: 'bold',
    color: 'white'
  },
  title: {
    color: '#424242',
    // fontWeight: 'bold'
  },
  train: {
    fontSize: 21,
    color: 'white',
  },
  trainWrapper: {
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 75,
  },
  content: {
    color: 'white',
    fontSize: 21,

  },
  logo: {
    position: 'absolute',
    top: 4,
    right:3,
    width,
    height: height * .7,
    resizeMode: 'contain',
    opacity: .3
  },
  arrivalCounter: {
    position: 'absolute',
    // flexDirection: 'row',
    bottom: 20,
    height: height * .43,
    width: width * .8,
    backgroundColor: 'rgba(0,0,0,.8)',
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 15,
  },
  counter: {
    fontSize: 50,
    marginRight: 10,
    color: 'rgba(0,188,212,1)'
  },
  counterText: {
    fontSize: 21,
    color: 'rgba(0,188,212,.5)',
    color: 'white'
  },
  alertModal: {
    position: 'absolute',
    height,
    width,
    backgroundColor: 'rgba(0,0,0,.8)',
    justifyContent: 'center',
    alignItems: 'center',
  },
  alertModalCard: {
    backgroundColor: 'rgba(0,0,0,0)',
    overflow: 'hidden',
    height: height * .3,
    width: height * .3,
    borderRadius: 15,
    justifyContent: 'center',
    alignItems: 'center'
  },
  arrivedUserImg: {
    height: 80,
    width: 80,
    marginTop: -100,
    borderRadius: 40,
  },
  arriveName: {
    alignSelf: 'flex-start',
    position: 'absolute',
    top: 200,
    marginLeft: 30,
    fontSize: 21,
    fontWeight: 'bold',
    color: 'rgba(0,188,212,1)'
  },
  arriveText: {
    alignSelf: 'flex-end',
    position: 'absolute',
    bottom: 240,
    right: 70,
    fontSize: 17,
    fontWeight: 'bold',
    color: 'rgba(0,188,212,1)',
    color: '#e0e0e0'
  },
  pattern: {
    position: 'absolute',
    top: -12,
    height: height * .3,
    width: width * .5,
    resizeMode: 'contain',
    opacity: 1,
  }
})
