#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" rtimulib
    popd
    exit
fi

RTIMULIB_VERSION=7.2.1
download https://launchpad.net/~flexiondotorg/+archive/ubuntu/wily-pi/+files/rtimulib_$RTIMULIB_VERSION.orig.tar.gz rtimulib-$RTIMULIB_VERSION.tar.gz

mkdir -p $PLATFORM
cd $PLATFORM
tar -xzvf ../rtimulib-$RTIMULIB_VERSION.tar.gz
cd rtimulib-$RTIMULIB_VERSION
mkdir build
cd build

case $PLATFORM in
    linux-arm)
        $CMAKE -DCMAKE_INSTALL_PREFIX=../.. ../RTIMULib
        make -j4
        make install/strip
        ;;
    linux-x86_64)
        $CMAKE -DCMAKE_INSTALL_PREFIX=../.. ../RTIMULib
        make -j4
        make install/strip
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../../..
