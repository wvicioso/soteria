
import React, { Component } from 'react';
import { Image, View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch, TextInput } from 'react-native'
const { height, width } = Dimensions.get('window');
import EmailInput from './emailInput';


export default class Login extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: ''
    }
  }

  login() {
    this.props.navigation.navigate('First')
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <Image style={styles.background}
          blurRadius={5}
          source={require('../../nyc-walk.jpg')}
        />
        <View style={styles.filter}/>
        <Text style={styles.header}>Rendezvous</Text>
        <EmailInput />
        <TextInput
          placeholder='Password'
          placeholderTextColor='#e0e0e0'
          secureTextEntry
          style={styles.password}
          // style={{height: 40, borderColor: 'gray', borderWidth: 1}}
          // onChangeText={(text) => this.setState({text})}
          // value={this.state.text}
        />
        <TouchableOpacity style={styles.login} onPress={this.login.bind(this)}>
          <Text style={{fontWeight: 'bold', color: 'white', fontSize: 17}}>
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
  background: {
    position: 'absolute',
    width,
    height
  },
  filter: {
    backgroundColor: 'rgba(0,0,0,.5)',
    position: 'absolute',
    width,
    height
  },
  header: {
    position: 'absolute',
    top: 50,
    alignSelf: 'center',
    fontWeight: 'bold',
    fontSize: 27,
    color: 'rgba(0,188,212,1)',
    // shadowColor: 'rgba(255,255,255,.5)',
    // shadowOffset: { width: 0, height: 1 },
    // shadowOpacity: 1,
    // shadowRadius: 4,
  },
  password: {
    fontWeight: 'bold',
    height: height * .05,
    // backgroundColor: '#e0e0e0',
    borderBottomWidth: 0,
    borderBottomColor: 'rgba(255,255,255,.4)',
    backgroundColor: 'rgba(0,188,212,.5)',
    borderRadius: 25,
    paddingLeft: 20,
    width: width * .85,
    marginTop: 10,
    color: 'white'
  },
  login: {
    position: 'absolute',
    bottom: 100,
    // marginTop: 70,
    padding: 15,
    paddingRight: 50,
    paddingLeft: 50,
    // backgroundColor: 'rgba(255,255,255,.7)',
    backgroundColor: 'rgba(0,188,212,1)',
    borderRadius: 10
  }
})
