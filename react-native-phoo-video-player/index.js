/**
 * Created by phoobobo on 2018/2/6.
 * Dragon Trail Interactive All Rights Reserved.
 */
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

export default requireNativeComponent('PhooVideoPlayer', iFace, {
    nativeOnly: { fullscreen: false }
});
