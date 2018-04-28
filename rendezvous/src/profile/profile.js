import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'

export default class Profile extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {

    }
  }


  render() {
    return (
      <View style={styles.wrapper}>
        <Text>Profile</Text>
      </View>
    );
  }
}

let styles = StyleSheet.create({
  wrapper: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  }
})
