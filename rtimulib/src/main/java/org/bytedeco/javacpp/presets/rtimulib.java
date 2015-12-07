package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(target = "org.bytedeco.javacpp.rtimulib", value = {
    @Platform(include = {"RTMath.h", "RTIMUHal.h", "RTIMULibDefs.h", "RTIMUSettings.h", "IMUDrivers/RTIMU.h", "IMUDrivers/RTHumidity.h", "IMUDrivers/RTPressure.h"},
        link = "RTIMULib")})
public class rtimulib implements InfoMapper {
  public void map(InfoMap infoMap) {
    infoMap.put(new Info("zero").javaNames("resetToZero"));
  }
}

