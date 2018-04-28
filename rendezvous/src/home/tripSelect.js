import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'

export default class TripSelect extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {

    }
  }


  navBack() {
    this.props.navigation.goBack();
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <TouchableOpacity>
          <Text style={this.navBack.bind(this)}>Back</Text>
        </TouchableOpacity>
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
  }
})
