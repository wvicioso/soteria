
import React, { Component } from 'react';
import { View, Image, Text, TouchableOpacity, Dimensions, StyleSheet, Switch, TextInput } from 'react-native'
const { height, width } = Dimensions.get('window');



export default class EmailInput extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      email: 'wvicioso',
      collegeOffest: 0,
      collegeOpacity: 0,
      college: '',
      collegeSelected: false
    }
  }

  toggleCollege() {
    this.state.collegeOffest == 0 ?
    this.setState({
      collegeOffest: 70,
      collegeOpacity: 1,

      college: '',
    }) :
    this.setState({
      collegeOffest: 0,
      collegeOpacity: 0,

    })
  }

  appendCollege(college) {
    let newEmail = this.state.email + '@' + college
    this.setState({
      college: college
    })
    this.props.updateEmail(newEmail);
    this.toggleCollege(newEmail);
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <View style={styles.inputSection}>
          <TextInput
            autoCapitalize={false}
            placeholder="School Email"
            placeholderTextColor='#e0e0e0'
            onChangeText={(text) => {this.setState({email: text})}}
            value={this.state.email}
            style={styles.emailInput}
          />
        </View>

        <View style={styles.atSymbol}>
          <Text style={{fontWeight: 'bold', color: 'white', fontSize: 21}}>@</Text>
        </View>

        <View style={styles.collegeEnding}>
          <TouchableOpacity style={styles.showColleges} onPress={this.toggleCollege.bind(this)}>
            {
              this.state.college ?
              <Text style={styles.collegeEndingInput}>{this.state.college}</Text> :
              <Text style={styles.collegeEndingInput}>Show Colleges</Text>
            }
          </TouchableOpacity>
          <View style={[styles.colleges, {height: this.state.collegeOffest, opacity: this.state.collegeOpacity}]}>
            <TouchableOpacity style={styles.collegeChoices} onPress={this.appendCollege.bind(this, 'baruchmail.cuny.edu')}>
              <Text style={styles.collegeText}>
                Baruch College
              </Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.collegeChoices} onPress={this.appendCollege.bind(this, 'citymail.cuny.edu')}>
              <Text style={styles.collegeText}>
                City College
              </Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.collegeChoices} onPress={this.appendCollege.bind(this, 'lc.cuny.edu')}>
              <Text style={styles.collegeText}>
                Leman College
              </Text>
            </TouchableOpacity>
          </View>
        </View>
      </View>
    );
  }
}

let styles = StyleSheet.create({
    wrapper: {
      flexDirection: 'row',
      height: height * .1,
      width: width * .9,
      justifyContent: 'space-around',
      alignItems: 'center'
    },
    colleges: {
      zIndex: 1000000,
      height: 0,
      width: width * .25,
    },
    inputSection: {
      height: height * .1,
      width: width * .45,
      justifyContent: 'center',
      alignItems: 'center',
    },
    atSymbol: {
      height: height * .1,
      width: width * .05,
      justifyContent: 'center',
      alignItems: 'center',
    },
    collegeEnding: {
      height: height * .1,
      width: width * .4,
      justifyContent: 'center',
      alignItems: 'center',
      borderRadius: 10
    },
    emailInput: {
      borderBottomWidth: .5,
      borderBottomColor: 'rgba(255,255,255,.4)',
      padding: 10,
      width: width * .4,
      color: 'white',
      fontWeight: 'bold',
    },
    collegeEndingInput: {
      color: '#424242',
      fontWeight: 'bold',
      fontSize: 12,
      alignSelf: 'flex-start'
    },
    showColleges: {
        backgroundColor: 'rgba(255,255,255,.7)',
        padding: 10,
        borderRadius: 10
    },
    collegeChoices: {
      backgroundColor: '#e0e0e050',
      borderRadius: 5,
      marginTop: 5,
      width: width * .28,
      marginLeft: -6
    },
    collegeText:  {
      paddingRight: 2,
      paddingLeft: 2,
      paddingTop: 5,
      paddingBottom: 5,
      color: 'rgba(0,188,212,.8)',
      textAlign: 'center',
      fontSize: 12,
      fontWeight: 'bold'
    }
  })
