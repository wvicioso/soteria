
import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch, TextInput } from 'react-native'
import EmailInput from './emailInput';
const { height, width } = Dimensions.get('window');


export default class Login extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: ''
    }
  }

  login() {
    // debugger
    this.props.navigation.navigate('First')
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <Text style={styles.header}>Rendezvous</Text>
        <EmailInput />
        <TextInput
          placeholder='Password'
          style={styles.password}
          // style={{height: 40, borderColor: 'gray', borderWidth: 1}}
          // onChangeText={(text) => this.setState({text})}
          // value={this.state.text}
        />
        <TouchableOpacity onPress={this.login.bind(this)}>
          <Text>
            Login
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
    alignItems: 'center',
  },
  header: {
    position: 'absolute',
    top: 50,
    alignSelf: 'center',
    fontWeight: 'bold',
    fontSize: 21
  },
  password: {
    height: height * .1,
    backgroundColor: '#e0e0e0',
    width: width * .9,
    borderRadius: 10,
    marginTop: 10

  }
})
