// Targeted by JavaCPP version 1.2-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

public class rtimulib extends org.bytedeco.javacpp.presets.rtimulib {
    static { Loader.load(); }

// Parsed from RTMath.h

////////////////////////////////////////////////////////////////////////////
//
//  This file is part of RTIMULib
//
//  Copyright (c) 2014-2015, richards-tech, LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to use,
//  copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
//  Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
//  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
//  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
//  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

// #ifndef _RTMATH_H_
// #define _RTMATH_H_

// #include "RTIMUHal.h"

//  The fundamental float type

// #ifdef RTMATH_USE_DOUBLE
// #else
// #endif

//  Useful constants

public static final double RTMATH_PI =					3.1415926535;
public static final double RTMATH_DEGREE_TO_RAD =		(RTMATH_PI / 180.0);
public static final double RTMATH_RAD_TO_DEGREE =		(180.0 / RTMATH_PI);

public static class RTMath extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RTMath() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTMath(int size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTMath(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public RTMath position(int position) {
        return (RTMath)super.position(position);
    }

    // convenient display routines

    public static native @Cast("const char*") BytePointer displayRadians(@Cast("const char*") BytePointer label, @ByRef RTVector3 vec);
    public static native String displayRadians(String label, @ByRef RTVector3 vec);
    public static native @Cast("const char*") BytePointer displayDegrees(@Cast("const char*") BytePointer label, @ByRef RTVector3 vec);
    public static native String displayDegrees(String label, @ByRef RTVector3 vec);
    public static native @Cast("const char*") BytePointer display(@Cast("const char*") BytePointer label, @ByRef RTQuaternion quat);
    public static native String display(String label, @ByRef RTQuaternion quat);
    public static native @Cast("const char*") BytePointer display(@Cast("const char*") BytePointer label, @ByRef RTMatrix4x4 mat);
    public static native String display(String label, @ByRef RTMatrix4x4 mat);

    //  currentUSecsSinceEpoch() is the source of all timestamps and
    //  is the number of uS since the standard epoch

    public static native @Cast("uint64_t") long currentUSecsSinceEpoch();

    //  poseFromAccelMag generates pose Euler angles from measured settings

    public static native @ByVal RTVector3 poseFromAccelMag(@Const @ByRef RTVector3 accel, @Const @ByRef RTVector3 mag);

    //  Takes signed 16 bit data from a char array and converts it to a vector of scaled RTFLOATs

    public static native void convertToVector(@Cast("unsigned char*") BytePointer rawData, @ByRef RTVector3 vec, @Cast("RTFLOAT") double scale, @Cast("bool") boolean bigEndian);
    public static native void convertToVector(@Cast("unsigned char*") ByteBuffer rawData, @ByRef RTVector3 vec, @Cast("RTFLOAT") double scale, @Cast("bool") boolean bigEndian);
    public static native void convertToVector(@Cast("unsigned char*") byte[] rawData, @ByRef RTVector3 vec, @Cast("RTFLOAT") double scale, @Cast("bool") boolean bigEndian);

    //  Takes a pressure in hPa and returns height above sea level in meters

    public static native @Cast("RTFLOAT") double convertPressureToHeight(@Cast("RTFLOAT") double pressure, @Cast("RTFLOAT") double staticPressure/*=1013.25*/);
    public static native @Cast("RTFLOAT") double convertPressureToHeight(@Cast("RTFLOAT") double pressure);
}


@NoOffset public static class RTVector3 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTVector3(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTVector3(int size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RTVector3 position(int position) {
        return (RTVector3)super.position(position);
    }

    public RTVector3() { super((Pointer)null); allocate(); }
    private native void allocate();
    public RTVector3(@Cast("RTFLOAT") double x, @Cast("RTFLOAT") double y, @Cast("RTFLOAT") double z) { super((Pointer)null); allocate(x, y, z); }
    private native void allocate(@Cast("RTFLOAT") double x, @Cast("RTFLOAT") double y, @Cast("RTFLOAT") double z);

    public native @Const @ByRef @Name("operator +=") RTVector3 addPut(@ByRef RTVector3 vec);
    public native @Const @ByRef @Name("operator -=") RTVector3 subtractPut(@ByRef RTVector3 vec);

    public native @ByRef @Name("operator =") RTVector3 put(@Const @ByRef RTVector3 vec);

    public native @Cast("RTFLOAT") double length();
    public native void normalize();
    public native @Name("zero") void resetToZero();
    public native @Cast("const char*") BytePointer display();
    public native @Cast("const char*") BytePointer displayDegrees();

    public static native float dotProduct(@Const @ByRef RTVector3 a, @Const @ByRef RTVector3 b);
    public static native void crossProduct(@Const @ByRef RTVector3 a, @Const @ByRef RTVector3 b, @ByRef RTVector3 d);

    public native void accelToEuler(@ByRef RTVector3 rollPitchYaw);
    public native void accelToQuaternion(@ByRef RTQuaternion qPose);

    public native @Cast("RTFLOAT") double x();
    public native @Cast("RTFLOAT") double y();
    public native @Cast("RTFLOAT") double z();
    public native @Cast("RTFLOAT") double data(int i);

    public native void setX(@Cast("const RTFLOAT") double val);
    public native void setY(@Cast("const RTFLOAT") double val);
    public native void setZ(@Cast("const RTFLOAT") double val);
    public native void setData(int i, @Cast("RTFLOAT") double val);
    public native void fromArray(@Cast("RTFLOAT*") DoublePointer val);
    public native void fromArray(@Cast("RTFLOAT*") DoubleBuffer val);
    public native void fromArray(@Cast("RTFLOAT*") double[] val);
    public native void toArray(@Cast("RTFLOAT*") DoublePointer val);
    public native void toArray(@Cast("RTFLOAT*") DoubleBuffer val);
    public native void toArray(@Cast("RTFLOAT*") double[] val);
}


@NoOffset public static class RTQuaternion extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTQuaternion(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTQuaternion(int size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RTQuaternion position(int position) {
        return (RTQuaternion)super.position(position);
    }

    public RTQuaternion() { super((Pointer)null); allocate(); }
    private native void allocate();
    public RTQuaternion(@Cast("RTFLOAT") double scalar, @Cast("RTFLOAT") double x, @Cast("RTFLOAT") double y, @Cast("RTFLOAT") double z) { super((Pointer)null); allocate(scalar, x, y, z); }
    private native void allocate(@Cast("RTFLOAT") double scalar, @Cast("RTFLOAT") double x, @Cast("RTFLOAT") double y, @Cast("RTFLOAT") double z);

    public native @ByRef @Name("operator +=") RTQuaternion addPut(@Const @ByRef RTQuaternion quat);
    public native @ByRef @Name("operator -=") RTQuaternion subtractPut(@Const @ByRef RTQuaternion quat);
    public native @ByRef @Name("operator *=") RTQuaternion multiplyPut(@Const @ByRef RTQuaternion qb);
    public native @ByRef @Name("operator *=") RTQuaternion multiplyPut(@Cast("const RTFLOAT") double val);
    public native @ByRef @Name("operator -=") RTQuaternion subtractPut(@Cast("const RTFLOAT") double val);

    public native @ByRef @Name("operator =") RTQuaternion put(@Const @ByRef RTQuaternion quat);
    public native @Const @ByVal @Name("operator *") RTQuaternion multiply(@Const @ByRef RTQuaternion qb);
    public native @Const @ByVal @Name("operator *") RTQuaternion multiply(@Cast("const RTFLOAT") double val);
    public native @Const @ByVal @Name("operator -") RTQuaternion subtract(@Const @ByRef RTQuaternion qb);
    public native @Const @ByVal @Name("operator -") RTQuaternion subtract(@Cast("const RTFLOAT") double val);

    public native void normalize();
    public native void toEuler(@ByRef RTVector3 vec);
    public native void fromEuler(@ByRef RTVector3 vec);
    public native @ByVal RTQuaternion conjugate();
    public native void toAngleVector(@Cast("RTFLOAT*") @ByRef DoublePointer angle, @ByRef RTVector3 vec);
    public native void toAngleVector(@Cast("RTFLOAT*") @ByRef DoubleBuffer angle, @ByRef RTVector3 vec);
    public native void toAngleVector(@Cast("RTFLOAT*") @ByRef double[] angle, @ByRef RTVector3 vec);
    public native void fromAngleVector(@Cast("const RTFLOAT") double angle, @Const @ByRef RTVector3 vec);

    public native @Name("zero") void resetToZero();
    public native @Cast("const char*") BytePointer display();

    public native @Cast("RTFLOAT") double scalar();
    public native @Cast("RTFLOAT") double x();
    public native @Cast("RTFLOAT") double y();
    public native @Cast("RTFLOAT") double z();
    public native @Cast("RTFLOAT") double data(int i);

    public native void setScalar(@Cast("const RTFLOAT") double val);
    public native void setX(@Cast("const RTFLOAT") double val);
    public native void setY(@Cast("const RTFLOAT") double val);
    public native void setZ(@Cast("const RTFLOAT") double val);
    public native void setData(int i, @Cast("RTFLOAT") double val);
    public native void fromArray(@Cast("RTFLOAT*") DoublePointer val);
    public native void fromArray(@Cast("RTFLOAT*") DoubleBuffer val);
    public native void fromArray(@Cast("RTFLOAT*") double[] val);
    public native void toArray(@Cast("RTFLOAT*") DoublePointer val);
    public native void toArray(@Cast("RTFLOAT*") DoubleBuffer val);
    public native void toArray(@Cast("RTFLOAT*") double[] val);
}

@NoOffset public static class RTMatrix4x4 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTMatrix4x4(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTMatrix4x4(int size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RTMatrix4x4 position(int position) {
        return (RTMatrix4x4)super.position(position);
    }

    public RTMatrix4x4() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native @ByRef @Name("operator +=") RTMatrix4x4 addPut(@Const @ByRef RTMatrix4x4 mat);
    public native @ByRef @Name("operator -=") RTMatrix4x4 subtractPut(@Const @ByRef RTMatrix4x4 mat);
    public native @ByRef @Name("operator *=") RTMatrix4x4 multiplyPut(@Cast("const RTFLOAT") double val);

    public native @ByRef @Name("operator =") RTMatrix4x4 put(@Const @ByRef RTMatrix4x4 vec);
    public native @Const @ByVal @Name("operator *") RTQuaternion multiply(@Const @ByRef RTQuaternion q);
    public native @Const @ByVal @Name("operator *") RTMatrix4x4 multiply(@Cast("const RTFLOAT") double val);
    public native @Const @ByVal @Name("operator *") RTMatrix4x4 multiply(@Const @ByRef RTMatrix4x4 mat);
    public native @Const @ByVal @Name("operator +") RTMatrix4x4 add(@Const @ByRef RTMatrix4x4 mat);

    public native @Cast("RTFLOAT") double val(int row, int col);
    public native void setVal(int row, int col, @Cast("RTFLOAT") double val);
    public native void fill(@Cast("RTFLOAT") double val);
    public native void setToIdentity();

    public native @ByVal RTMatrix4x4 inverted();
    public native @ByVal RTMatrix4x4 transposed();
}

// #endif /* _RTMATH_H_ */


// Parsed from RTIMUHal.h

////////////////////////////////////////////////////////////////////////////
//
//  This file is part of RTIMULib
//
//  Copyright (c) 2014-2015, richards-tech, LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to use,
//  copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
//  Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
//  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
//  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
//  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

//  The MPU-9250 and SPI driver code is based on code generously supplied by
//  staslock@gmail.com (www.clickdrive.io)

// #ifndef _RTIMUHAL_H
// #define	_RTIMUHAL_H

// #include <stdio.h>
// #include <math.h>
// #include <stdint.h>
// #include <fcntl.h>
// #include <string.h>
// #include <stdlib.h>

// #ifndef HAL_QUIET
// #define HAL_INFO(m) { printf("%s", m); fflush(stdout); }
// #define HAL_INFO1(m, x) { printf(m, x); fflush(stdout); }
// #define HAL_INFO2(m, x, y) { printf(m, x, y); fflush(stdout); }
// #define HAL_INFO3(m, x, y, z) { printf(m, x, y, z); fflush(stdout); }
// #define HAL_INFO4(m, x, y, z, a) { printf(m, x, y, z, a); fflush(stdout); }
// #define HAL_INFO5(m, x, y, z, a, b) { printf(m, x, y, z, a, b); fflush(stdout); }
// #define HAL_ERROR(m)    fprintf(stderr, m);
// #define HAL_ERROR1(m, x)    fprintf(stderr, m, x);
// #define HAL_ERROR2(m, x, y)    fprintf(stderr, m, x, y);
// #define HAL_ERROR3(m, x, y, z)    fprintf(stderr, m, x, y, z);
// #define HAL_ERROR4(m, x, y, z, a)    fprintf(stderr, m, x, y, z, a);

// #else

// #define HAL_INFO(m)
// #define HAL_INFO1(m, x)
// #define HAL_INFO2(m, x, y)
// #define HAL_INFO3(m, x, y, z)
// #define HAL_INFO4(m, x, y, z, a)
// #define HAL_INFO5(m, x, y, z, a, b)
// #define HAL_ERROR(m)
// #define HAL_ERROR1(m, x)
// #define HAL_ERROR2(m, x, y)
// #define HAL_ERROR3(m, x, y, z)
// #define HAL_ERROR4(m, x, y, z, a)

// #endif

// #if !defined(WIN32) && !defined(__APPLE__)
// #include <sys/ioctl.h>
// #include <linux/i2c-dev.h>
// #endif

// #if !defined(WIN32)
// #include <unistd.h>
// #include <sys/time.h>
// #endif

public static final int MAX_WRITE_LEN =                   255;
public static final int MAX_READ_LEN =                    255;

@NoOffset public static class RTIMUHal extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTIMUHal(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTIMUHal(int size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RTIMUHal position(int position) {
        return (RTIMUHal)super.position(position);
    }

    public RTIMUHal() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native @Cast("bool") boolean m_busIsI2C(); public native RTIMUHal m_busIsI2C(boolean m_busIsI2C);                                        // true if I2C bus in use, false if SPI in use
    public native @Cast("unsigned char") byte m_I2CBus(); public native RTIMUHal m_I2CBus(byte m_I2CBus);                                 // I2C bus of the imu (eg 1 for Raspberry Pi usually)
    public native @Cast("unsigned char") byte m_SPIBus(); public native RTIMUHal m_SPIBus(byte m_SPIBus);                                 // SPI bus of the imu (eg 0 for Raspberry Pi usually)
    public native @Cast("unsigned char") byte m_SPISelect(); public native RTIMUHal m_SPISelect(byte m_SPISelect);                              // SPI select line - defaults to CE0
    public native @Cast("unsigned int") int m_SPISpeed(); public native RTIMUHal m_SPISpeed(int m_SPISpeed);                                // speed of interface

    public native @Cast("bool") boolean HALOpen();
    public native void HALClose();
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") BytePointer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") ByteBuffer data, String errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") byte[] data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") BytePointer data, String errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") ByteBuffer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") byte[] data, String errorMsg);    // normal read with register select
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") BytePointer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") ByteBuffer data, String errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") byte[] data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") BytePointer data, String errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") ByteBuffer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALRead(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte length,
                     @Cast("unsigned char*") byte[] data, String errorMsg);    // read without register select
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") BytePointer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") ByteBuffer data, String errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") byte[] data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") BytePointer data, String errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") ByteBuffer data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char") byte length, @Cast("unsigned char const*") byte[] data, String errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char const") byte data, @Cast("const char*") BytePointer errorMsg);
    public native @Cast("bool") boolean HALWrite(@Cast("unsigned char") byte slaveAddr, @Cast("unsigned char") byte regAddr,
                      @Cast("unsigned char const") byte data, String errorMsg);

    public native void delayMs(int milliSeconds);
}

// #endif // _RTIMUHAL_H


// Parsed from RTIMULibDefs.h

////////////////////////////////////////////////////////////////////////////
//
//  This file is part of RTIMULib
//
//  Copyright (c) 2014-2015, richards-tech, LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to use,
//  copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
//  Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
//  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
//  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
//  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

//  The MPU-9250 and SPI driver code is based on code generously supplied by
//  staslock@gmail.com (www.clickdrive.io)

// #ifndef _RTIMULIBDEFS_H
// #define	_RTIMULIBDEFS_H

// #include "RTMath.h"
// #include "IMUDrivers/RTIMUDefs.h"

//  these defines describe the various fusion filter options

public static final int RTFUSION_TYPE_NULL =                  0;                   // just a dummy to keep things happy if not needed
public static final int RTFUSION_TYPE_KALMANSTATE4 =          1;                   // kalman state is the quaternion pose
public static final int RTFUSION_TYPE_RTQF =                  2;                   // RT quaternion fusion

public static final int RTFUSION_TYPE_COUNT =                 3;                   // number of fusion algorithm types

//  This is a convenience structure that can be used to pass IMU data around

public static class RTIMU_DATA extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RTIMU_DATA() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTIMU_DATA(int size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTIMU_DATA(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public RTIMU_DATA position(int position) {
        return (RTIMU_DATA)super.position(position);
    }

    public native @Cast("uint64_t") long timestamp(); public native RTIMU_DATA timestamp(long timestamp);
    public native @Cast("bool") boolean fusionPoseValid(); public native RTIMU_DATA fusionPoseValid(boolean fusionPoseValid);
    public native @ByRef RTVector3 fusionPose(); public native RTIMU_DATA fusionPose(RTVector3 fusionPose);
    public native @Cast("bool") boolean fusionQPoseValid(); public native RTIMU_DATA fusionQPoseValid(boolean fusionQPoseValid);
    public native @ByRef RTQuaternion fusionQPose(); public native RTIMU_DATA fusionQPose(RTQuaternion fusionQPose);
    public native @Cast("bool") boolean gyroValid(); public native RTIMU_DATA gyroValid(boolean gyroValid);
    public native @ByRef RTVector3 gyro(); public native RTIMU_DATA gyro(RTVector3 gyro);
    public native @Cast("bool") boolean accelValid(); public native RTIMU_DATA accelValid(boolean accelValid);
    public native @ByRef RTVector3 accel(); public native RTIMU_DATA accel(RTVector3 accel);
    public native @Cast("bool") boolean compassValid(); public native RTIMU_DATA compassValid(boolean compassValid);
    public native @ByRef RTVector3 compass(); public native RTIMU_DATA compass(RTVector3 compass);
    public native @Cast("bool") boolean pressureValid(); public native RTIMU_DATA pressureValid(boolean pressureValid);
    public native @Cast("RTFLOAT") double pressure(); public native RTIMU_DATA pressure(double pressure);
    public native @Cast("bool") boolean temperatureValid(); public native RTIMU_DATA temperatureValid(boolean temperatureValid);
    public native @Cast("RTFLOAT") double temperature(); public native RTIMU_DATA temperature(double temperature);
    public native @Cast("bool") boolean humidityValid(); public native RTIMU_DATA humidityValid(boolean humidityValid);
    public native @Cast("RTFLOAT") double humidity(); public native RTIMU_DATA humidity(double humidity);
}

// #endif // _RTIMULIBDEFS_H


// Parsed from RTIMUSettings.h

////////////////////////////////////////////////////////////////////////////
//
//  This file is part of RTIMULib
//
//  Copyright (c) 2014-2015, richards-tech, LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to use,
//  copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
//  Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
//  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
//  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
//  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

//  The MPU-9250 and SPI driver code is based on code generously supplied by
//  staslock@gmail.com (www.clickdrive.io)

// #ifndef _RTIMUSETTINGS_H
// #define _RTIMUSETTINGS_H

// #include "RTMath.h"
// #include "RTIMUHal.h"

//  Settings keys

public static final String RTIMULIB_IMU_TYPE =                   "IMUType";
public static final String RTIMULIB_FUSION_TYPE =                "FusionType";
public static final String RTIMULIB_BUS_IS_I2C =                 "BusIsI2C";
public static final String RTIMULIB_I2C_SLAVEADDRESS =           "I2CSlaveAddress";
public static final String RTIMULIB_I2C_BUS =                    "I2CBus";
public static final String RTIMULIB_SPI_BUS =                    "SPIBus";
public static final String RTIMULIB_SPI_SELECT =                 "SPISelect";
public static final String RTIMULIB_SPI_SPEED =                  "SPISpeed";
public static final String RTIMULIB_AXIS_ROTATION =              "AxisRotation";
public static final String RTIMULIB_PRESSURE_TYPE =              "PressureType";
public static final String RTIMULIB_I2C_PRESSUREADDRESS =        "I2CPressureAddress";
public static final String RTIMULIB_HUMIDITY_TYPE =              "HumidityType";
public static final String RTIMULIB_I2C_HUMIDITYADDRESS =        "I2CHumidityAddress";

//  MPU9150 settings keys

public static final String RTIMULIB_MPU9150_GYROACCEL_SAMPLERATE = "MPU9150GyroAccelSampleRate";
public static final String RTIMULIB_MPU9150_COMPASS_SAMPLERATE = "MPU9150CompassSampleRate";
public static final String RTIMULIB_MPU9150_GYROACCEL_LPF =      "MPU9150GyroAccelLpf";
public static final String RTIMULIB_MPU9150_GYRO_FSR =           "MPU9150GyroFSR";
public static final String RTIMULIB_MPU9150_ACCEL_FSR =          "MPU9150AccelFSR";

//  MPU9250 settings keys

public static final String RTIMULIB_MPU9250_GYROACCEL_SAMPLERATE = "MPU9250GyroAccelSampleRate";
public static final String RTIMULIB_MPU9250_COMPASS_SAMPLERATE = "MPU9250CompassSampleRate";
public static final String RTIMULIB_MPU9250_GYRO_LPF =           "MPU9250GyroLpf";
public static final String RTIMULIB_MPU9250_ACCEL_LPF =          "MPU9250AccelLpf";
public static final String RTIMULIB_MPU9250_GYRO_FSR =           "MPU9250GyroFSR";
public static final String RTIMULIB_MPU9250_ACCEL_FSR =          "MPU9250AccelFSR";

//  GD20HM303D settings keys

public static final String RTIMULIB_GD20HM303D_GYRO_SAMPLERATE =   "GD20HM303DGyroSampleRate";
public static final String RTIMULIB_GD20HM303D_GYRO_BW =           "GD20HM303DGyroBW";
public static final String RTIMULIB_GD20HM303D_GYRO_HPF =          "GD20HM303DGyroHpf";
public static final String RTIMULIB_GD20HM303D_GYRO_FSR =          "GD20HM303DGyroFsr";

public static final String RTIMULIB_GD20HM303D_ACCEL_SAMPLERATE =  "GD20HM303DAccelSampleRate";
public static final String RTIMULIB_GD20HM303D_ACCEL_FSR =         "GD20HM303DAccelFsr";
public static final String RTIMULIB_GD20HM303D_ACCEL_LPF =         "GD20HM303DAccelLpf";

public static final String RTIMULIB_GD20HM303D_COMPASS_SAMPLERATE = "GD20HM303DCompassSampleRate";
public static final String RTIMULIB_GD20HM303D_COMPASS_FSR =       "GD20HM303DCompassFsr";


//  GD20M303DLHC settings keys

public static final String RTIMULIB_GD20M303DLHC_GYRO_SAMPLERATE =   "GD20M303DLHCGyroSampleRate";
public static final String RTIMULIB_GD20M303DLHC_GYRO_BW =           "GD20M303DLHCGyroBW";
public static final String RTIMULIB_GD20M303DLHC_GYRO_HPF =          "GD20M303DLHCGyroHpf";
public static final String RTIMULIB_GD20M303DLHC_GYRO_FSR =          "GD20M303DLHCGyroFsr";

public static final String RTIMULIB_GD20M303DLHC_ACCEL_SAMPLERATE =  "GD20M303DLHCAccelSampleRate";
public static final String RTIMULIB_GD20M303DLHC_ACCEL_FSR =         "GD20M303DLHCAccelFsr";

public static final String RTIMULIB_GD20M303DLHC_COMPASS_SAMPLERATE = "GD20M303DLHCCompassSampleRate";
public static final String RTIMULIB_GD20M303DLHC_COMPASS_FSR =       "GD20M303DLHCCompassFsr";

//  GD20HM303DLHC settings keys

public static final String RTIMULIB_GD20HM303DLHC_GYRO_SAMPLERATE =  "GD20HM303DLHCGyroSampleRate";
public static final String RTIMULIB_GD20HM303DLHC_GYRO_BW =          "GD20HM303DLHCGyroBW";
public static final String RTIMULIB_GD20HM303DLHC_GYRO_HPF =         "GD20HM303DLHCGyroHpf";
public static final String RTIMULIB_GD20HM303DLHC_GYRO_FSR =         "GD20HM303DLHCGyroFsr";

public static final String RTIMULIB_GD20HM303DLHC_ACCEL_SAMPLERATE = "GD20HM303DLHCAccelSampleRate";
public static final String RTIMULIB_GD20HM303DLHC_ACCEL_FSR =        "GD20HM303DLHCAccelFsr";

public static final String RTIMULIB_GD20HM303DLHC_COMPASS_SAMPLERATE = "GD20HM303DLHCCompassSampleRate";
public static final String RTIMULIB_GD20HM303DLHC_COMPASS_FSR =      "GD20HM303DLHCCompassFsr";


//  LSM9DS0 settings keys

public static final String RTIMULIB_LSM9DS0_GYRO_SAMPLERATE =   "LSM9DS0GyroSampleRate";
public static final String RTIMULIB_LSM9DS0_GYRO_BW =           "LSM9DS0GyroBW";
public static final String RTIMULIB_LSM9DS0_GYRO_HPF =          "LSM9DS0GyroHpf";
public static final String RTIMULIB_LSM9DS0_GYRO_FSR =          "LSM9DS0GyroFsr";

public static final String RTIMULIB_LSM9DS0_ACCEL_SAMPLERATE =  "LSM9DS0AccelSampleRate";
public static final String RTIMULIB_LSM9DS0_ACCEL_FSR =         "LSM9DS0AccelFsr";
public static final String RTIMULIB_LSM9DS0_ACCEL_LPF =         "LSM9DS0AccelLpf";

public static final String RTIMULIB_LSM9DS0_COMPASS_SAMPLERATE = "LSM9DS0CompassSampleRate";
public static final String RTIMULIB_LSM9DS0_COMPASS_FSR =       "LSM9DS0CompassFsr";

//  LSM9DS1 settings keys

public static final String RTIMULIB_LSM9DS1_GYRO_SAMPLERATE =   "LSM9DS1GyroSampleRate";
public static final String RTIMULIB_LSM9DS1_GYRO_BW =           "LSM9DS1GyroBW";
public static final String RTIMULIB_LSM9DS1_GYRO_HPF =          "LSM9DS1GyroHpf";
public static final String RTIMULIB_LSM9DS1_GYRO_FSR =          "LSM9DS1GyroFsr";

public static final String RTIMULIB_LSM9DS1_ACCEL_SAMPLERATE =  "LSM9DS1AccelSampleRate";
public static final String RTIMULIB_LSM9DS1_ACCEL_FSR =         "LSM9DS1AccelFsr";
public static final String RTIMULIB_LSM9DS1_ACCEL_LPF =         "LSM9DS1AccelLpf";

public static final String RTIMULIB_LSM9DS1_COMPASS_SAMPLERATE = "LSM9DS1CompassSampleRate";
public static final String RTIMULIB_LSM9DS1_COMPASS_FSR =       "LSM9DS1CompassFsr";

//  BMX055 settings keys

public static final String RTIMULIB_BMX055_GYRO_SAMPLERATE =     "BMX055GyroSampleRate";
public static final String RTIMULIB_BMX055_GYRO_FSR =            "BMX055GyroFsr";

public static final String RTIMULIB_BMX055_ACCEL_SAMPLERATE =    "BMX055AccelSampleRate";
public static final String RTIMULIB_BMX055_ACCEL_FSR =           "BMX055AccelFsr";

public static final String RTIMULIB_BMX055_MAG_PRESET =          "BMX055MagPreset";

//  Gyro bias keys

public static final String RTIMULIB_GYRO_BIAS_VALID =            "GyroBiasValid";
public static final String RTIMULIB_GYRO_BIAS_X =                "GyroBiasX";
public static final String RTIMULIB_GYRO_BIAS_Y =                "GyroBiasY";
public static final String RTIMULIB_GYRO_BIAS_Z =                "GyroBiasZ";

//  Compass calibration and adjustment settings keys

public static final String RTIMULIB_COMPASSCAL_VALID =           "CompassCalValid";
public static final String RTIMULIB_COMPASSCAL_MINX =            "CompassCalMinX";
public static final String RTIMULIB_COMPASSCAL_MAXX =            "CompassCalMaxX";
public static final String RTIMULIB_COMPASSCAL_MINY =            "CompassCalMinY";
public static final String RTIMULIB_COMPASSCAL_MAXY =            "CompassCalMaxY";
public static final String RTIMULIB_COMPASSCAL_MINZ =            "CompassCalMinZ";
public static final String RTIMULIB_COMPASSCAL_MAXZ =            "CompassCalMaxZ";

public static final String RTIMULIB_COMPASSCAL_ELLIPSOID_VALID = "compassCalEllipsoidValid";
public static final String RTIMULIB_COMPASSCAL_OFFSET_X =        "compassCalOffsetX";
public static final String RTIMULIB_COMPASSCAL_OFFSET_Y =        "compassCalOffsetY";
public static final String RTIMULIB_COMPASSCAL_OFFSET_Z =        "compassCalOffsetZ";
public static final String RTIMULIB_COMPASSCAL_CORR11 =          "compassCalCorr11";
public static final String RTIMULIB_COMPASSCAL_CORR12 =          "compassCalCorr12";
public static final String RTIMULIB_COMPASSCAL_CORR13 =          "compassCalCorr13";
public static final String RTIMULIB_COMPASSCAL_CORR21 =          "compassCalCorr21";
public static final String RTIMULIB_COMPASSCAL_CORR22 =          "compassCalCorr22";
public static final String RTIMULIB_COMPASSCAL_CORR23 =          "compassCalCorr23";
public static final String RTIMULIB_COMPASSCAL_CORR31 =          "compassCalCorr31";
public static final String RTIMULIB_COMPASSCAL_CORR32 =          "compassCalCorr32";
public static final String RTIMULIB_COMPASSCAL_CORR33 =          "compassCalCorr33";

public static final String RTIMULIB_COMPASSADJ_DECLINATION =     "compassAdjDeclination";

//  Accel calibration settings keys

public static final String RTIMULIB_ACCELCAL_VALID =             "AccelCalValid";
public static final String RTIMULIB_ACCELCAL_MINX =              "AccelCalMinX";
public static final String RTIMULIB_ACCELCAL_MAXX =              "AccelCalMaxX";
public static final String RTIMULIB_ACCELCAL_MINY =              "AccelCalMinY";
public static final String RTIMULIB_ACCELCAL_MAXY =              "AccelCalMaxY";
public static final String RTIMULIB_ACCELCAL_MINZ =              "AccelCalMinZ";
public static final String RTIMULIB_ACCELCAL_MAXZ =              "AccelCalMaxZ";


@NoOffset public static class RTIMUSettings extends RTIMUHal {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTIMUSettings(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RTIMUSettings(int size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RTIMUSettings position(int position) {
        return (RTIMUSettings)super.position(position);
    }


    //  Standard constructor sets up for ini file in working directory

    public RTIMUSettings(@Cast("const char*") BytePointer productType/*="RTIMULib"*/) { super((Pointer)null); allocate(productType); }
    private native void allocate(@Cast("const char*") BytePointer productType/*="RTIMULib"*/);
    public RTIMUSettings() { super((Pointer)null); allocate(); }
    private native void allocate();
    public RTIMUSettings(String productType/*="RTIMULib"*/) { super((Pointer)null); allocate(productType); }
    private native void allocate(String productType/*="RTIMULib"*/);

    //  Alternate constructor allow ini file to be in any directory

    public RTIMUSettings(@Cast("const char*") BytePointer settingsDirectory, @Cast("const char*") BytePointer productType) { super((Pointer)null); allocate(settingsDirectory, productType); }
    private native void allocate(@Cast("const char*") BytePointer settingsDirectory, @Cast("const char*") BytePointer productType);
    public RTIMUSettings(String settingsDirectory, String productType) { super((Pointer)null); allocate(settingsDirectory, productType); }
    private native void allocate(String settingsDirectory, String productType);

    //  This function tries to find an IMU. It stops at the first valid one
    //  and returns true or else false

    public native @Cast("bool") boolean discoverIMU(@ByRef IntPointer imuType, @Cast("bool*") @ByRef BoolPointer busIsI2C, @Cast("unsigned char*") @ByRef BytePointer slaveAddress);
    public native @Cast("bool") boolean discoverIMU(@ByRef IntBuffer imuType, @Cast("bool*") @ByRef boolean[] busIsI2C, @Cast("unsigned char*") @ByRef ByteBuffer slaveAddress);
    public native @Cast("bool") boolean discoverIMU(@ByRef int[] imuType, @Cast("bool*") @ByRef BoolPointer busIsI2C, @Cast("unsigned char*") @ByRef byte[] slaveAddress);
    public native @Cast("bool") boolean discoverIMU(@ByRef IntPointer imuType, @Cast("bool*") @ByRef boolean[] busIsI2C, @Cast("unsigned char*") @ByRef BytePointer slaveAddress);
    public native @Cast("bool") boolean discoverIMU(@ByRef IntBuffer imuType, @Cast("bool*") @ByRef BoolPointer busIsI2C, @Cast("unsigned char*") @ByRef ByteBuffer slaveAddress);
    public native @Cast("bool") boolean discoverIMU(@ByRef int[] imuType, @Cast("bool*") @ByRef boolean[] busIsI2C, @Cast("unsigned char*") @ByRef byte[] slaveAddress);

    //  This function tries to find a pressure sensor. It stops at the first valid one
    //  and returns true or else false

    public native @Cast("bool") boolean discoverPressure(@ByRef IntPointer pressureType, @Cast("unsigned char*") @ByRef BytePointer pressureAddress);
    public native @Cast("bool") boolean discoverPressure(@ByRef IntBuffer pressureType, @Cast("unsigned char*") @ByRef ByteBuffer pressureAddress);
    public native @Cast("bool") boolean discoverPressure(@ByRef int[] pressureType, @Cast("unsigned char*") @ByRef byte[] pressureAddress);

    //  This function tries to find a humidity sensor. It stops at the first valid one
    //  and returns true or else false

    public native @Cast("bool") boolean discoverHumidity(@ByRef IntPointer humidityType, @Cast("unsigned char*") @ByRef BytePointer humidityAddress);
    public native @Cast("bool") boolean discoverHumidity(@ByRef IntBuffer humidityType, @Cast("unsigned char*") @ByRef ByteBuffer humidityAddress);
    public native @Cast("bool") boolean discoverHumidity(@ByRef int[] humidityType, @Cast("unsigned char*") @ByRef byte[] humidityAddress);

    //  This function sets the settings to default values.

    public native void setDefaults();

    //  This function loads the local variables from the settings file or uses defaults

    public native @Cast("bool") boolean loadSettings();

    //  This function saves the local variables to the settings file

    public native @Cast("bool") boolean saveSettings();

    //  These are the local variables

    public native int m_imuType(); public native RTIMUSettings m_imuType(int m_imuType);                                          // type code of imu in use
    public native int m_fusionType(); public native RTIMUSettings m_fusionType(int m_fusionType);                                       // fusion algorithm type code
    public native @Cast("unsigned char") byte m_I2CSlaveAddress(); public native RTIMUSettings m_I2CSlaveAddress(byte m_I2CSlaveAddress);                        // I2C slave address of the imu
    public native int m_axisRotation(); public native RTIMUSettings m_axisRotation(int m_axisRotation);                                     // axis rotation code
    public native int m_pressureType(); public native RTIMUSettings m_pressureType(int m_pressureType);                                     // type code of pressure sensor in use
    public native @Cast("unsigned char") byte m_I2CPressureAddress(); public native RTIMUSettings m_I2CPressureAddress(byte m_I2CPressureAddress);                     // I2C slave address of the pressure sensor
    public native int m_humidityType(); public native RTIMUSettings m_humidityType(int m_humidityType);                                     // type code of humidity sensor in use
    public native @Cast("unsigned char") byte m_I2CHumidityAddress(); public native RTIMUSettings m_I2CHumidityAddress(byte m_I2CHumidityAddress);                     // I2C slave address of the humidity sensor

    public native @Cast("bool") boolean m_compassCalValid(); public native RTIMUSettings m_compassCalValid(boolean m_compassCalValid);                                 // true if there is valid compass calibration data
    public native @ByRef RTVector3 m_compassCalMin(); public native RTIMUSettings m_compassCalMin(RTVector3 m_compassCalMin);                              // the minimum values
    public native @ByRef RTVector3 m_compassCalMax(); public native RTIMUSettings m_compassCalMax(RTVector3 m_compassCalMax);                              // the maximum values

    public native @Cast("bool") boolean m_compassCalEllipsoidValid(); public native RTIMUSettings m_compassCalEllipsoidValid(boolean m_compassCalEllipsoidValid);                        // true if the ellipsoid calibration data is valid
    public native @ByRef RTVector3 m_compassCalEllipsoidOffset(); public native RTIMUSettings m_compassCalEllipsoidOffset(RTVector3 m_compassCalEllipsoidOffset);                  // the ellipsoid offset
    public native float m_compassCalEllipsoidCorr(int i, int j); public native RTIMUSettings m_compassCalEllipsoidCorr(int i, int j, float m_compassCalEllipsoidCorr);
    @MemberGetter public native @Cast("float(*)[3]") FloatPointer m_compassCalEllipsoidCorr();                  // the correction matrix

    public native float m_compassAdjDeclination(); public native RTIMUSettings m_compassAdjDeclination(float m_compassAdjDeclination);                          // magnetic declination adjustment - subtracted from measured

    public native @Cast("bool") boolean m_accelCalValid(); public native RTIMUSettings m_accelCalValid(boolean m_accelCalValid);                                   // true if there is valid accel calibration data
    public native @ByRef RTVector3 m_accelCalMin(); public native RTIMUSettings m_accelCalMin(RTVector3 m_accelCalMin);                                // the minimum values
    public native @ByRef RTVector3 m_accelCalMax(); public native RTIMUSettings m_accelCalMax(RTVector3 m_accelCalMax);                                // the maximum values

    public native @Cast("bool") boolean m_gyroBiasValid(); public native RTIMUSettings m_gyroBiasValid(boolean m_gyroBiasValid);                                   // true if the recorded gyro bias is valid
    public native @ByRef RTVector3 m_gyroBias(); public native RTIMUSettings m_gyroBias(RTVector3 m_gyroBias);                                   // the recorded gyro bias

    //  IMU-specific vars

    //  MPU9150

    public native int m_MPU9150GyroAccelSampleRate(); public native RTIMUSettings m_MPU9150GyroAccelSampleRate(int m_MPU9150GyroAccelSampleRate);                       // the sample rate (samples per second) for gyro and accel
    public native int m_MPU9150CompassSampleRate(); public native RTIMUSettings m_MPU9150CompassSampleRate(int m_MPU9150CompassSampleRate);                         // same for the compass
    public native int m_MPU9150GyroAccelLpf(); public native RTIMUSettings m_MPU9150GyroAccelLpf(int m_MPU9150GyroAccelLpf);                              // low pass filter code for the gyro and accel
    public native int m_MPU9150GyroFsr(); public native RTIMUSettings m_MPU9150GyroFsr(int m_MPU9150GyroFsr);                                   // FSR code for the gyro
    public native int m_MPU9150AccelFsr(); public native RTIMUSettings m_MPU9150AccelFsr(int m_MPU9150AccelFsr);                                  // FSR code for the accel

    //  MPU9250

    public native int m_MPU9250GyroAccelSampleRate(); public native RTIMUSettings m_MPU9250GyroAccelSampleRate(int m_MPU9250GyroAccelSampleRate);                       // the sample rate (samples per second) for gyro and accel
    public native int m_MPU9250CompassSampleRate(); public native RTIMUSettings m_MPU9250CompassSampleRate(int m_MPU9250CompassSampleRate);                         // same for the compass
    public native int m_MPU9250GyroLpf(); public native RTIMUSettings m_MPU9250GyroLpf(int m_MPU9250GyroLpf);                                   // low pass filter code for the gyro
    public native int m_MPU9250AccelLpf(); public native RTIMUSettings m_MPU9250AccelLpf(int m_MPU9250AccelLpf);                                  // low pass filter code for the accel
    public native int m_MPU9250GyroFsr(); public native RTIMUSettings m_MPU9250GyroFsr(int m_MPU9250GyroFsr);                                   // FSR code for the gyro
    public native int m_MPU9250AccelFsr(); public native RTIMUSettings m_MPU9250AccelFsr(int m_MPU9250AccelFsr);                                  // FSR code for the accel

    //  GD20HM303D

    public native int m_GD20HM303DGyroSampleRate(); public native RTIMUSettings m_GD20HM303DGyroSampleRate(int m_GD20HM303DGyroSampleRate);                         // the gyro sample rate
    public native int m_GD20HM303DGyroBW(); public native RTIMUSettings m_GD20HM303DGyroBW(int m_GD20HM303DGyroBW);                                 // the gyro bandwidth code
    public native int m_GD20HM303DGyroHpf(); public native RTIMUSettings m_GD20HM303DGyroHpf(int m_GD20HM303DGyroHpf);                                // the gyro high pass filter cutoff code
    public native int m_GD20HM303DGyroFsr(); public native RTIMUSettings m_GD20HM303DGyroFsr(int m_GD20HM303DGyroFsr);                                // the gyro full scale range

    public native int m_GD20HM303DAccelSampleRate(); public native RTIMUSettings m_GD20HM303DAccelSampleRate(int m_GD20HM303DAccelSampleRate);                        // the accel sample rate
    public native int m_GD20HM303DAccelFsr(); public native RTIMUSettings m_GD20HM303DAccelFsr(int m_GD20HM303DAccelFsr);                               // the accel full scale range
    public native int m_GD20HM303DAccelLpf(); public native RTIMUSettings m_GD20HM303DAccelLpf(int m_GD20HM303DAccelLpf);                               // the accel low pass filter

    public native int m_GD20HM303DCompassSampleRate(); public native RTIMUSettings m_GD20HM303DCompassSampleRate(int m_GD20HM303DCompassSampleRate);                      // the compass sample rate
    public native int m_GD20HM303DCompassFsr(); public native RTIMUSettings m_GD20HM303DCompassFsr(int m_GD20HM303DCompassFsr);                             // the compass full scale range

    //  GD20M303DLHC

    public native int m_GD20M303DLHCGyroSampleRate(); public native RTIMUSettings m_GD20M303DLHCGyroSampleRate(int m_GD20M303DLHCGyroSampleRate);                       // the gyro sample rate
    public native int m_GD20M303DLHCGyroBW(); public native RTIMUSettings m_GD20M303DLHCGyroBW(int m_GD20M303DLHCGyroBW);                               // the gyro bandwidth code
    public native int m_GD20M303DLHCGyroHpf(); public native RTIMUSettings m_GD20M303DLHCGyroHpf(int m_GD20M303DLHCGyroHpf);                              // the gyro high pass filter cutoff code
    public native int m_GD20M303DLHCGyroFsr(); public native RTIMUSettings m_GD20M303DLHCGyroFsr(int m_GD20M303DLHCGyroFsr);                              // the gyro full scale range

    public native int m_GD20M303DLHCAccelSampleRate(); public native RTIMUSettings m_GD20M303DLHCAccelSampleRate(int m_GD20M303DLHCAccelSampleRate);                      // the accel sample rate
    public native int m_GD20M303DLHCAccelFsr(); public native RTIMUSettings m_GD20M303DLHCAccelFsr(int m_GD20M303DLHCAccelFsr);                             // the accel full scale range

    public native int m_GD20M303DLHCCompassSampleRate(); public native RTIMUSettings m_GD20M303DLHCCompassSampleRate(int m_GD20M303DLHCCompassSampleRate);                    // the compass sample rate
    public native int m_GD20M303DLHCCompassFsr(); public native RTIMUSettings m_GD20M303DLHCCompassFsr(int m_GD20M303DLHCCompassFsr);                           // the compass full scale range

    //  GD20HM303DLHC

    public native int m_GD20HM303DLHCGyroSampleRate(); public native RTIMUSettings m_GD20HM303DLHCGyroSampleRate(int m_GD20HM303DLHCGyroSampleRate);                      // the gyro sample rate
    public native int m_GD20HM303DLHCGyroBW(); public native RTIMUSettings m_GD20HM303DLHCGyroBW(int m_GD20HM303DLHCGyroBW);                              // the gyro bandwidth code
    public native int m_GD20HM303DLHCGyroHpf(); public native RTIMUSettings m_GD20HM303DLHCGyroHpf(int m_GD20HM303DLHCGyroHpf);                             // the gyro high pass filter cutoff code
    public native int m_GD20HM303DLHCGyroFsr(); public native RTIMUSettings m_GD20HM303DLHCGyroFsr(int m_GD20HM303DLHCGyroFsr);                             // the gyro full scale range

    public native int m_GD20HM303DLHCAccelSampleRate(); public native RTIMUSettings m_GD20HM303DLHCAccelSampleRate(int m_GD20HM303DLHCAccelSampleRate);                     // the accel sample rate
    public native int m_GD20HM303DLHCAccelFsr(); public native RTIMUSettings m_GD20HM303DLHCAccelFsr(int m_GD20HM303DLHCAccelFsr);                            // the accel full scale range

    public native int m_GD20HM303DLHCCompassSampleRate(); public native RTIMUSettings m_GD20HM303DLHCCompassSampleRate(int m_GD20HM303DLHCCompassSampleRate);                   // the compass sample rate
    public native int m_GD20HM303DLHCCompassFsr(); public native RTIMUSettings m_GD20HM303DLHCCompassFsr(int m_GD20HM303DLHCCompassFsr);                          // the compass full scale range

    //  LSM9DS0

    public native int m_LSM9DS0GyroSampleRate(); public native RTIMUSettings m_LSM9DS0GyroSampleRate(int m_LSM9DS0GyroSampleRate);                            // the gyro sample rate
    public native int m_LSM9DS0GyroBW(); public native RTIMUSettings m_LSM9DS0GyroBW(int m_LSM9DS0GyroBW);                                    // the gyro bandwidth code
    public native int m_LSM9DS0GyroHpf(); public native RTIMUSettings m_LSM9DS0GyroHpf(int m_LSM9DS0GyroHpf);                                   // the gyro high pass filter cutoff code
    public native int m_LSM9DS0GyroFsr(); public native RTIMUSettings m_LSM9DS0GyroFsr(int m_LSM9DS0GyroFsr);                                   // the gyro full scale range

    public native int m_LSM9DS0AccelSampleRate(); public native RTIMUSettings m_LSM9DS0AccelSampleRate(int m_LSM9DS0AccelSampleRate);                           // the accel sample rate
    public native int m_LSM9DS0AccelFsr(); public native RTIMUSettings m_LSM9DS0AccelFsr(int m_LSM9DS0AccelFsr);                                  // the accel full scale range
    public native int m_LSM9DS0AccelLpf(); public native RTIMUSettings m_LSM9DS0AccelLpf(int m_LSM9DS0AccelLpf);                                  // the accel low pass filter

    public native int m_LSM9DS0CompassSampleRate(); public native RTIMUSettings m_LSM9DS0CompassSampleRate(int m_LSM9DS0CompassSampleRate);                         // the compass sample rate
    public native int m_LSM9DS0CompassFsr(); public native RTIMUSettings m_LSM9DS0CompassFsr(int m_LSM9DS0CompassFsr);                                // the compass full scale range

    //  LSM9DS1

    public native int m_LSM9DS1GyroSampleRate(); public native RTIMUSettings m_LSM9DS1GyroSampleRate(int m_LSM9DS1GyroSampleRate);                            // the gyro sample rate
    public native int m_LSM9DS1GyroBW(); public native RTIMUSettings m_LSM9DS1GyroBW(int m_LSM9DS1GyroBW);                                    // the gyro bandwidth code
    public native int m_LSM9DS1GyroHpf(); public native RTIMUSettings m_LSM9DS1GyroHpf(int m_LSM9DS1GyroHpf);                                   // the gyro high pass filter cutoff code
    public native int m_LSM9DS1GyroFsr(); public native RTIMUSettings m_LSM9DS1GyroFsr(int m_LSM9DS1GyroFsr);                                   // the gyro full scale range

    public native int m_LSM9DS1AccelSampleRate(); public native RTIMUSettings m_LSM9DS1AccelSampleRate(int m_LSM9DS1AccelSampleRate);                           // the accel sample rate
    public native int m_LSM9DS1AccelFsr(); public native RTIMUSettings m_LSM9DS1AccelFsr(int m_LSM9DS1AccelFsr);                                  // the accel full scale range
    public native int m_LSM9DS1AccelLpf(); public native RTIMUSettings m_LSM9DS1AccelLpf(int m_LSM9DS1AccelLpf);                                  // the accel low pass filter

    public native int m_LSM9DS1CompassSampleRate(); public native RTIMUSettings m_LSM9DS1CompassSampleRate(int m_LSM9DS1CompassSampleRate);                         // the compass sample rate
    public native int m_LSM9DS1CompassFsr(); public native RTIMUSettings m_LSM9DS1CompassFsr(int m_LSM9DS1CompassFsr);                                // the compass full scale range

    //  BMX055

    public native int m_BMX055GyroSampleRate(); public native RTIMUSettings m_BMX055GyroSampleRate(int m_BMX055GyroSampleRate);                             // the gyro sample rate
    public native int m_BMX055GyroFsr(); public native RTIMUSettings m_BMX055GyroFsr(int m_BMX055GyroFsr);                                    // the gyro full scale range

    public native int m_BMX055AccelSampleRate(); public native RTIMUSettings m_BMX055AccelSampleRate(int m_BMX055AccelSampleRate);                            // the accel sample rate
    public native int m_BMX055AccelFsr(); public native RTIMUSettings m_BMX055AccelFsr(int m_BMX055AccelFsr);                                   // the accel full scale range

    public native int m_BMX055MagPreset(); public native RTIMUSettings m_BMX055MagPreset(int m_BMX055MagPreset);
}

// #endif // _RTIMUSETTINGS_H



// Parsed from IMUDrivers/RTIMU.h

////////////////////////////////////////////////////////////////////////////
//
//  This file is part of RTIMULib
//
//  Copyright (c) 2014-2015, richards-tech, LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to use,
//  copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
//  Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
//  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
//  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
//  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

// #ifndef _RTIMU_H
// #define	_RTIMU_H

// #include "RTMath.h"
// #include "RTFusion.h"
// #include "RTIMULibDefs.h"
// #include "RTIMUSettings.h"

//  Axis rotation defs
//
//  These allow the IMU to be virtually repositioned if it is in a non-standard configuration
//  Standard configuration is X pointing at north, Y pointing east and Z pointing down
//  with the IMU horizontal. There are 24 different possible orientations as defined
//  below. Setting the axis rotation code to non-zero values performs the repositioning.

public static final int RTIMU_XNORTH_YEAST =              0;                   // this is the default identity matrix
public static final int RTIMU_XEAST_YSOUTH =              1;
public static final int RTIMU_XSOUTH_YWEST =              2;
public static final int RTIMU_XWEST_YNORTH =              3;
public static final int RTIMU_XNORTH_YWEST =              4;
public static final int RTIMU_XEAST_YNORTH =              5;
public static final int RTIMU_XSOUTH_YEAST =              6;
public static final int RTIMU_XWEST_YSOUTH =              7;
public static final int RTIMU_XUP_YNORTH =                8;
public static final int RTIMU_XUP_YEAST =                 9;
public static final int RTIMU_XUP_YSOUTH =                10;
public static final int RTIMU_XUP_YWEST =                 11;
public static final int RTIMU_XDOWN_YNORTH =              12;
public static final int RTIMU_XDOWN_YEAST =               13;
public static final int RTIMU_XDOWN_YSOUTH =              14;
public static final int RTIMU_XDOWN_YWEST =               15;
public static final int RTIMU_XNORTH_YUP =                16;
public static final int RTIMU_XEAST_YUP =                 17;
public static final int RTIMU_XSOUTH_YUP =                18;
public static final int RTIMU_XWEST_YUP =                 19;
public static final int RTIMU_XNORTH_YDOWN =              20;
public static final int RTIMU_XEAST_YDOWN =               21;
public static final int RTIMU_XSOUTH_YDOWN =              22;
public static final int RTIMU_XWEST_YDOWN =               23;

public static final int RTIMU_AXIS_ROTATION_COUNT =       24;

@NoOffset public static class RTIMU extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RTIMU(Pointer p) { super(p); }

    //  IMUs should always be created with the following call

    public static native RTIMU createIMU(RTIMUSettings settings);

    //  Constructor/destructor

    //  These functions must be provided by sub classes

    public native @Cast("const char*") BytePointer IMUName();                      // the name of the IMU
    public native int IMUType();                              // the type code of the IMU
    public native @Cast("bool") boolean IMUInit();                             // set up the IMU
    public native int IMUGetPollInterval();                   // returns the recommended poll interval in mS
    public native @Cast("bool") boolean IMURead();                             // get a sample

    // setGyroContinuousALearninglpha allows the continuous learning rate to be over-ridden
    // The value must be between 0.0 and 1.0 and will generally be close to 0

    public native @Cast("bool") boolean setGyroContinuousLearningAlpha(@Cast("RTFLOAT") double alpha);

    // returns true if enough samples for valid data

    public native @Cast("bool") boolean IMUGyroBiasValid();

    //  the following function can be called to set the SLERP power

    public native void setSlerpPower(@Cast("RTFLOAT") double power);

    //  call the following to reset the fusion algorithm

    public native void resetFusion();

    //  the following three functions control the influence of the gyro, accel and compass sensors

    public native void setGyroEnable(@Cast("bool") boolean enable);
    public native void setAccelEnable(@Cast("bool") boolean enable);
    public native void setCompassEnable(@Cast("bool") boolean enable);

    //  call the following to enable debug messages

    public native void setDebugEnable(@Cast("bool") boolean enable);

    //  getIMUData returns the standard outputs of the IMU and fusion filter

    public native @Const @ByRef RTIMU_DATA getIMUData();

    //  setExtIMUData allows data from some external IMU to be injected to the fusion algorithm

    public native void setExtIMUData(@Cast("RTFLOAT") double gx, @Cast("RTFLOAT") double gy, @Cast("RTFLOAT") double gz, @Cast("RTFLOAT") double ax, @Cast("RTFLOAT") double ay, @Cast("RTFLOAT") double az,
            @Cast("RTFLOAT") double mx, @Cast("RTFLOAT") double my, @Cast("RTFLOAT") double mz, @Cast("uint64_t") long timestamp);

    //  the following two functions get access to the measured pose (accel and compass)

    public native @Const @ByRef RTVector3 getMeasuredPose();
    public native @Const @ByRef RTQuaternion getMeasuredQPose();

    //  setCompassCalibrationMode() turns off use of cal data so that raw data can be accumulated
    //  to derive calibration data

    public native void setCompassCalibrationMode(@Cast("bool") boolean enable);

    //  setAccelCalibrationMode() turns off use of cal data so that raw data can be accumulated
    //  to derive calibration data

    public native void setAccelCalibrationMode(@Cast("bool") boolean enable);

    //  setCalibrationData configures the cal data from settings and also enables use if valid

    public native void setCalibrationData();

    //  getCompassCalibrationValid() returns true if the compass min/max calibration data is being used

    public native @Cast("bool") boolean getCompassCalibrationValid();

    //  getCompassCalibrationEllipsoidValid() returns true if the compass ellipsoid calibration data is being used

    public native @Cast("bool") boolean getCompassCalibrationEllipsoidValid();

    //  getAccelCalibrationValid() returns true if the accel calibration data is being used

    public native @Cast("bool") boolean getAccelCalibrationValid();

    public native @Const @ByRef RTVector3 getGyro();   // gets gyro rates in radians/sec
    public native @Const @ByRef RTVector3 getAccel(); // get accel data in gs
    public native @Const @ByRef RTVector3 getCompass(); // gets compass data in uT

    public native @ByVal RTVector3 getAccelResiduals();

 }

// #endif // _RTIMU_H


}
