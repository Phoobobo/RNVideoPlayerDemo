/**
 * Created by phoobobo on 2018/2/6.
 * Dragon Trail Interactive All Rights Reserved.
 */
import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { requireNativeComponent, View } from 'react-native';

const iFace = {
    name: 'PhooVideoPlayer',
    propTypes: {
        ...View.propTypes,
        src: PropTypes.string,
        coverImgUrl: PropTypes.string,
        fullscreen: PropTypes.bool,
    },
};

export default class PhooVideoPlayer extends Component {
    static propTypes = {
        src: PropTypes.string,
        coverImgUrl: PropTypes.string,
        fullscreen: PropTypes.bool,
        onPlayPrepared: PropTypes.func,
        ...View.propTypes,
    };

    // static name = 'PhooVideoPlayer';

    render() {
        const nativeProps = Object.assign({}, this.props);
        return (
            <VideoPlayer
                {...nativeProps}
            />
        )
    }
}

const VideoPlayer = requireNativeComponent('PhooVideoPlayer', PhooVideoPlayer, {
    nativeOnly: { fullscreen: false }
});
