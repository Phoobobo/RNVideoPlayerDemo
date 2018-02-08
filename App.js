/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    Dimensions,
} from 'react-native';
import PhooVideoPlayer from './react-native-phoo-video-player';

const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
    android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

const src = 'http://video.pearvideo.com/mp4/short/20180205/cont-1273507-11540028-hd.mp4';
const src2 = 'http://video.pearvideo.com/mp4/third/20180205/11308777_134140-hd.mp4';
const cover = 'http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db032f61b48166d224e4ade6e.jpg';

export default class App extends Component<{}> {
    static navigatorStyle = {
        navBarBackgroundColor: '#f7f7f7',
        navBarHidden: true,
    };
    render() {
        return (
            <View style={styles.container}>
                <PhooVideoPlayer
                    style={styles.video}
                    src={src}
                    coverImgUrl={cover}
                    // renderToHardwareTextureAndroid={true}
                />
                <Text style={styles.welcome}>
                    Welcome to React Native!
                </Text>
                <Text style={styles.instructions}>
                    To get started, edit App.js
                </Text>
                <Text style={styles.instructions}>
                    {instructions}
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'flex-start',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
    video: {
        height: 270,
        width: Dimensions.get('window').width,
    }
});
