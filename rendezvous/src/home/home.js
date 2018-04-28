import React, { Component } from 'react';
import { View, TextInput, Image, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
const { height, width } = Dimensions.get('window');


export default class Home extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {

    }
  }


  sendInfo() {
    this.props.navigation.navigate('TripSelect')
  }


  render() {
    return (
      <View style={styles.wrapper}>
        <Image
          style={styles.background}
          blurRadius={1.5}
          source={require('../../map.png')}
        />
        <View style={styles.filter}/>
        <Text style={styles.text}>Where do you want to go?</Text>
        <TextInput style={styles.input} placeholder="Place" />
        <Text style={styles.text}>What time do you want to leave?</Text>
        <TextInput style={styles.input} placeholder="time" />

        <TouchableOpacity onPress={this.sendInfo.bind(this)} style={styles.nextButton}>
          <Text style={{color: '#e0e0e0'}}>
            BEAM ME UP!
          </Text>
        </TouchableOpacity>
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
    backgroundColor: 'rgba(0,0,0,.7)'
  },
  text: {
    color: 'white'
  },
  input: {
    backgroundColor: 'rgba(255,255,255,.5)',
    padding: 10,
    paddingRight: 50,
    paddingLeft: 50,
    borderRadius: 10,
    margin: 5
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
