import { AppRegistry } from 'react-native';
import { Navigation } from 'react-native-navigation';
import App from './App';

Navigation.registerComponent('demo.MainScreen', () => App);
Navigation.startSingleScreenApp({
    screen: {
        screen: 'demo.MainScreen',
        navigatorStyle: {
            navBarBackgroundColor: '#f7f7f7',
        },
    },
}).then(() => {});

// AppRegistry.registerComponent('RNVideoPlayerDemo', () => App);
