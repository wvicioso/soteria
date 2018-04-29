import React, { Component } from 'react';
import { StackNavigator, TabNavigator } from 'react-navigation';
import { View, Text, TouchableOpacity, Dimensions, StyleSheet, Switch } from 'react-native'
import Icon from 'react-native-vector-icons/dist/FontAwesome';
import CardStackStyleInterpolator from "react-navigation/src/views/CardStack/CardStackStyleInterpolator";

import Login from './login/login.js'
import Home from './home/home.js'
import Profile from './profile/profile.js'
import Third from './third/third.js'
import TripSelect from './home/tripSelect.js'

const { height, width } = Dimensions.get('window');

class Header extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  back() {
    this.props.navigation.goBack(null);
  }

  // navToTrips() {
  //   this.props.navigation.navigate('Trips');
  // }
  //
  // onSwitch() {
  //   if (this.state.travelModeBOOL) {
  //     alert('Travel Mode Off')
  //     this.setState({
  //       travelModeBOOL: false
  //     })
  //   } else {
  //     alert('Travel Mode On')
  //     this.setState({
  //       travelModeBOOL: true
  //     })
  //   }
  // }

  render() {
    return (
      <View style={headerStyles.wrapper}>
        <Text style={headerStyles.title}>Rendezvous</Text>
        {
          this.props.left ?
          <TouchableOpacity style={headerStyles.back} onPress={this.back.bind(this)}>
            {/* <Icon name={`chevron-left`} color={'black'} size={25} /> */}
            <Text>Back</Text>
          </TouchableOpacity> : <View/>
        }
        {/* {

        }
        {
          this.props.travel ?
            <TouchableOpacity style={headerStyles.back} onPress={this.navToTrips.bind(this)}>
              <Icon name={`dot-circle-o`} color={'rgba(0,188,212,1)'} size={25} />
            </TouchableOpacity> : <View/>
        }
        <Text style={headerStyles.text}>
          {this.props.title ? this.props.title : "A I R H E A D S"}
        </Text>
        {
          this.props.switch ?
          <Switch
            style={headerStyles.switch}
            // disabled
            onTintColor="rgba(84,199,242,1)"
            onValueChange={this.onSwitch.bind(this)}
            // testID
            // thumbTintColor="rgba(0,188,212,1)"
            // tintColor="rgba(0,188,212,1)"
            value={this.state.travelModeBOOL}
          /> : <View/>
        } */}
      </View>
    );
  }
}


let headerStyles = StyleSheet.create({
  wrapper: {
    backgroundColor: 'white',
    paddingTop: 40,
    height: height * .1,
    width: width,
    justifyContent: 'center',
    alignItems: 'center',
    borderBottomWidth: 5,
    borderBottomColor: 'white',
  },
  title: {
    fontSize: 16,
    fontWeight: '800'
  },
  back: {
    position: 'absolute',
    bottom: 0,
    left: 10,
  },
})



class Label extends Component<{}> {
  render() {
    return(
      <View style={[styles.wrapper, this.props.wrapperStyle]}>
        <Icon  style={{}} name={this.props.name} color={this.props.color} size={25} />
      </View>
    )
  }
}

let styles = StyleSheet.create({
  wrapper: {
    position: 'absolute',
    top: 0,
    bottom: 0,
    width: width/3,
    justifyContent: 'center',
    alignItems: 'center',
  },
})


const Tabs = TabNavigator(
  {
    First: {
      screen: Home,
      navigationOptions: {
        tabBarLabel: ({ focused }) => (
          <Label
            name='square-o'
            wrapperStyle={{
              borderBottomWidth: focused ? 2.5 : 0,
              borderBottomColor: 'rgba(0,188,212,1)',
            }}
            color={focused ? 'rgba(0,188,212,1)' : '#e0e0e0' }
          />
        ),
      }
    },
    Second: {
      screen: Profile,
      navigationOptions: {
        tabBarLabel: ({ focused }) => (
          <Label
            name='user-o'
            wrapperStyle={{
              borderBottomWidth: focused ? 2.5 : 0,
              borderBottomColor: 'rgba(0,188,212,1)',
            }}
            color={focused ? 'rgba(0,188,212,1)' : '#e0e0e0' }
          />
        ),
      }
    },
  },
  {
    // initialRouteName: 'LocalActivities',
    tabBarPosition: 'bottom',
    swipeEnabled: true,
    tabBarOptions: {
      activeTintColor: 'rgba(0,188,212,1)',
      style: {
        backgroundColor: 'white',
        borderTopWidth: 0,
        shadowOpacity: 1,
        shadowColor: 'rgba(45,45,45,.15)',
        shadowOffset: { width: 1, height: 1 },
        shadowRadius: 5,
      },
    }
  }
)

const RootNavigator = StackNavigator(
  {
    Login: {
      screen: Login,
      navigationOptions: {
        header: null,
        gesturesEnabled: false,
      }
    },
    Home: {
      screen: Tabs,
      navigationOptions: {
        gesturesEnabled: false,
        header: null,
        // header: ({ navigation }) => (
        //       <Header navigation={navigation}/>
        // ),
      }
    },
    TripSelect: {
      screen: TripSelect,
      navigationOptions: {
        gesturesEnabled: false,
        header: null,
        // header: ({ navigation }) => (
        //       <Header left navigation={navigation}/>
        // ),
      }
    },
  },
  {
    transitionConfig: () => ({
      screenInterpolator: props => {
        // Transitioning to search screen (navigate)
        // if (props.scene.route.routeName === 'EditProfile') {
        //   return CardStackStyleInterpolator.forVertical(props);
        // }

        const last = props.scenes[props.scenes.length - 1];

        // // Transitioning from search screen (goBack)
        // if (last.route.routeName === 'EditProfile') {
        //   return CardStackStyleInterpolator.forVertical(props);
        // }

        return CardStackStyleInterpolator.forHorizontal(props);
      },
    }),
    navigationOptions: {
      gesturesEnabled: false,
    },
    cardStyle: {
      // backgroundColor: 'white'
    }
  },

);

export default RootNavigator;
