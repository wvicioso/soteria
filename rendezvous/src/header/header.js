export default class Header extends Component<{}> {
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
