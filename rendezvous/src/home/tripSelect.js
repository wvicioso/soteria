import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
const { height, width } = Dimensions.get('window');



export default class TripSelect extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      userLat: '',
      userLng: '',
    }
  }

  componentDidMount() {
    this.getLocation();
  }

  getTrainOptions() {

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

  render() {
    return (
      <View style={styles.wrapper}>
        <View style={styles.card}>
          <Text>6 People Are</Text>
        </View>
        <Text>TripSelect</Text>
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
  card: {
    width: width * .9,
    height: height * .7,
    backgroundColor: '#e0e0e0',
    borderRadius: 20,
    justifyContent: 'center',
    alignItems: 'center'
  }
})
