#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" rtimulib2
    popd
    exit
fi

download https://github.com/richards-tech/RTIMULib2/archive/master.zip rtimulib2-master.zip

mkdir -p $PLATFORM
cd $PLATFORM
unzip ../rtimulib2-master.zip
cd RTIMULib2-master
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
