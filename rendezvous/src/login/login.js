
import React, { Component } from 'react';
import { Image, View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch, TextInput } from 'react-native'
const { height, width } = Dimensions.get('window');
import EmailInput from './emailInput';


export default class Login extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: 'werwerw'
    }
  }

  login() {
    this.props.navigation.navigate('First', {email: this.state.email});
  }

  updateEmail(email) {
    this.setState({email})
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <Image style={styles.background}
          blurRadius={5}
          source={require('../../nyc-walk.jpg')}
        />

        <View style={styles.filter}/>
        {/* <Text style={styles.header}>Rendezvous</Text> */}
        <EmailInput updateEmail={this.updateEmail.bind(this)}/>
        <TextInput
          value={this.state.password}
          placeholder='Password'
          placeholderTextColor='#e0e0e0'
          secureTextEntry
          style={styles.password}
        />
        <TouchableOpacity style={styles.login} onPress={this.login.bind(this)}>
          <Text style={{fontWeight: 'bold', color: 'white', fontSize: 17}}>
            Login
          </Text>
        </TouchableOpacity>
        <View style={styles.registerWrapper}>
          <Text style={styles.registerText}>Don't have an account?</Text>
          <TouchableOpacity>
            <Text style={styles.registerBtn}>Sign Up</Text>
          </TouchableOpacity>
        </View>
        <Image style={styles.logo}
          source={require('../../logo-final.png')}
        />
        <Image style={styles.logoBlue}
          source={require('../../logo-blue.png')}
        />
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
    top: 180,
    alignSelf: 'center',
    fontWeight: 'bold',
    fontSize: 37,
    color: 'rgba(0,188,212,1)',
    // opacity: 0
  },
  logo: {
    position: 'absolute',
    top: 50,
    width,
    height: 140,
    resizeMode: 'contain'
  },
  logoBlue: {
    position: 'absolute',
    top: 200,
    width,
    height: 30,
    resizeMode: 'contain'
  },
  password: {
    fontWeight: 'bold',
    height: height * .05,
    borderBottomWidth: 1,
    borderBottomColor: 'rgba(255,255,255,.4)',
    paddingLeft: 10,
    width: width * .85,
    marginTop: 10,
    color: 'white'
  },
  login: {
    position: 'absolute',
    bottom: 100,
    padding: 15,
    paddingRight: 120,
    paddingLeft: 120,
    backgroundColor: 'rgba(0,188,212,1)',
    borderRadius: 25
  },
  registerWrapper: {
    flexDirection: 'row',
    position: 'absolute',
    bottom: 25,
  },
  registerText: {
    color: 'white'
  },
  registerBtn: {
    color: 'white',
    fontWeight: 'bold',
    marginLeft: 5
  },
})
