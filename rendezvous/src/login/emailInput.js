
import React, { Component } from 'react';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch, TextInput } from 'react-native'
const { height, width } = Dimensions.get('window');



export default class EmailInput extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      collegeOffest: 0,
      college: '',
      collegeSelected: false
    }
  }

  toggleCollege() {
    this.state.collegeOffest == 0 ?
    this.setState({
      collegeOffest: 50,
      college: '',
    }) :
    this.setState({
      collegeOffest: 0,
    })
  }

  login() {
    this.props.navigation.navigate('First')
  }

  appendCollege(college) {
    let newEmail = this.state.email + college
    this.setState({
      college: newEmail
    })
    this.toggleCollege();
  }

  render() {
    return (
      <View style={styles.wrapper}>
        <View style={styles.inputSection}>
          <TextInput
            placeholder="School Email"
            onChangeText={(text) => {this.setState({email: text})}}
            value={this.state.email}
            style={styles.emailInput}
          />
        </View>

        <View style={styles.atSymbol}>
          <Text>@</Text>
        </View>

        <View style={styles.collegeEnding}>
          <View>
            <TouchableOpacity onPress={this.toggleCollege.bind(this)}>
              {
                this.state.college ?
                <Text style={styles.collegeEndingInput}>{this.state.college}</Text> :
                <Text style={styles.collegeEndingInput}>Show Colleges</Text>
              }
            </TouchableOpacity>
          </View>
          <View style={[styles.colleges, {height: this.state.collegeOffest}]}>
            <TouchableOpacity  onPress={this.appendCollege.bind(this, 'baruchmail.cuny.edu')}>
              <Text>Baruch</Text>
            </TouchableOpacity>
            <TouchableOpacity  onPress={this.appendCollege.bind(this, 'citymail.cuny.edu')}>
              <Text>City</Text>
            </TouchableOpacity>
            <TouchableOpacity  onPress={this.appendCollege.bind(this, 'lc.cuny.edu')}>
              <Text>Leman</Text>
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
      height: 0,
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
      borderBottomWidth: 1,
      borderBottomColor: '#e0e0e0',
      padding: 10,
      paddingRight: 30,
      paddingLeft: 30
    },
    collegeEndingInput: {
      color: '#bdbdbd'
    }
  })
