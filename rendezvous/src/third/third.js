import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'

export default class Third extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {

    }
  }


  render() {
    return (
      <View style={styles.wrapper}>
        <Text>Third</Text>
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
