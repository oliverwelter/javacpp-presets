// Targeted by JavaCPP version 1.2-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class opencv_photo extends org.bytedeco.javacpp.presets.opencv_photo {
    static { Loader.load(); }

// Parsed from <opencv2/photo/photo_c.h>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2008-2012, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_PHOTO_C_H__
// #define __OPENCV_PHOTO_C_H__

// #include "opencv2/core/core_c.h"

// #ifdef __cplusplus
// #endif

/** \addtogroup photo_c
  \{
  */

/* Inpainting algorithms */
/** enum InpaintingModes */
public static final int
    CV_INPAINT_NS      = 0,
    CV_INPAINT_TELEA   = 1;


/* Inpaints the selected region in the image */
public static native void cvInpaint( @Const CvArr src, @Const CvArr inpaint_mask,
                       CvArr dst, double inpaintRange, int flags );

/** \} */

// #ifdef __cplusplus //extern "C"
// #endif

// #endif //__OPENCV_PHOTO_C_H__


// Parsed from <opencv2/photo.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2008-2012, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_PHOTO_HPP__
// #define __OPENCV_PHOTO_HPP__

// #include "opencv2/core.hpp"
// #include "opencv2/imgproc.hpp"

/**
\defgroup photo Computational Photography
\{
    \defgroup photo_denoise Denoising
    \defgroup photo_hdr HDR imaging
<p>
This section describes high dynamic range imaging algorithms namely tonemapping, exposure alignment,
camera calibration with multiple exposures and exposure fusion.
    <p>
    \defgroup photo_clone Seamless Cloning
    \defgroup photo_render Non-Photorealistic Rendering
    \defgroup photo_c C API
\}
  */

/** \addtogroup photo
 *  \{
 <p>
 *  the inpainting algorithm */
/** enum cv:: */
public static final int
    INPAINT_NS    = 0, // Navier-Stokes algorithm
    INPAINT_TELEA = 1; // A. Telea algorithm

/** enum cv:: */
public static final int
    NORMAL_CLONE = 1,
    MIXED_CLONE  = 2,
    MONOCHROME_TRANSFER = 3;

/** enum cv:: */
public static final int
    RECURS_FILTER = 1,
    NORMCONV_FILTER = 2;

/** \brief Restores the selected region in an image using the region neighborhood.
<p>
@param src Input 8-bit 1-channel or 3-channel image.
@param inpaintMask Inpainting mask, 8-bit 1-channel image. Non-zero pixels indicate the area that
needs to be inpainted.
@param dst Output image with the same size and type as src .
@param inpaintRadius Radius of a circular neighborhood of each point inpainted that is considered
by the algorithm.
@param flags Inpainting method that could be one of the following:
-   **INPAINT_NS** Navier-Stokes based method [Navier01]
-   **INPAINT_TELEA** Method by Alexandru Telea \cite Telea04 .
<p>
The function reconstructs the selected image area from the pixel near the area boundary. The
function may be used to remove dust and scratches from a scanned photo, or to remove undesirable
objects from still images or video. See <http://en.wikipedia.org/wiki/Inpainting> for more details.
<p>
\note
   -   An example using the inpainting technique can be found at
        opencv_source_code/samples/cpp/inpaint.cpp
    -   (Python) An example using the inpainting technique can be found at
        opencv_source_code/samples/python/inpaint.py
 */
@Namespace("cv") public static native void inpaint( @ByVal Mat src, @ByVal Mat inpaintMask,
        @ByVal Mat dst, double inpaintRadius, int flags );

/** \addtogroup photo_denoise
 *  \{
<p>
/** \brief Perform image denoising using Non-local Means Denoising algorithm
<http://www.ipol.im/pub/algo/bcm_non_local_means_denoising/> with several computational
optimizations. Noise expected to be a gaussian white noise
<p>
@param src Input 8-bit 1-channel, 2-channel, 3-channel or 4-channel image.
@param dst Output image with the same size and type as src .
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Parameter regulating filter strength. Big h value perfectly removes noise but also
removes image details, smaller h value preserves details but also preserves some noise
<p>
This function expected to be applied to grayscale images. For colored images look at
fastNlMeansDenoisingColored. Advanced usage of this functions can be manual denoising of colored
image in different colorspaces. Such approach is used in fastNlMeansDenoisingColored by converting
image to CIELAB colorspace and then separately denoise L and AB components with different h
parameter.
 */
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst, float h/*=3*/,
        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst);

/** \brief Perform image denoising using Non-local Means Denoising algorithm
<http://www.ipol.im/pub/algo/bcm_non_local_means_denoising/> with several computational
optimizations. Noise expected to be a gaussian white noise
<p>
@param src Input 8-bit or 16-bit (only with NORM_L1) 1-channel,
2-channel, 3-channel or 4-channel image.
@param dst Output image with the same size and type as src .
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Array of parameters regulating filter strength, either one
parameter applied to all channels or one per channel in dst. Big h value
perfectly removes noise but also removes image details, smaller h
value preserves details but also preserves some noise
@param normType Type of norm used for weight calculation. Can be either NORM_L2 or NORM_L1
<p>
This function expected to be applied to grayscale images. For colored images look at
fastNlMeansDenoisingColored. Advanced usage of this functions can be manual denoising of colored
image in different colorspaces. Such approach is used in fastNlMeansDenoisingColored by converting
image to CIELAB colorspace and then separately denoise L and AB components with different h
parameter.
 */
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector FloatPointer h,
                                        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                        int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector FloatPointer h);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector FloatBuffer h,
                                        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                        int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector FloatBuffer h);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector float[] h,
                                        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                        int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoising( @ByVal Mat src, @ByVal Mat dst,
                                        @StdVector float[] h);

/** \brief Modification of fastNlMeansDenoising function for colored images
<p>
@param src Input 8-bit 3-channel image.
@param dst Output image with the same size and type as src .
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Parameter regulating filter strength for luminance component. Bigger h value perfectly
removes noise but also removes image details, smaller h value preserves details but also preserves
some noise
@param hColor The same as h but for color components. For most images value equals 10
will be enough to remove colored noise and do not distort colors
<p>
The function converts image to CIELAB colorspace and then separately denoise L and AB components
with given h parameters using fastNlMeansDenoising function.
 */
@Namespace("cv") public static native void fastNlMeansDenoisingColored( @ByVal Mat src, @ByVal Mat dst,
        float h/*=3*/, float hColor/*=3*/,
        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/);
@Namespace("cv") public static native void fastNlMeansDenoisingColored( @ByVal Mat src, @ByVal Mat dst);

/** \brief Modification of fastNlMeansDenoising function for images sequence where consequtive images have been
captured in small period of time. For example video. This version of the function is for grayscale
images or for manual manipulation with colorspaces. For more details see
<http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.131.6394>
<p>
@param srcImgs Input 8-bit 1-channel, 2-channel, 3-channel or
4-channel images sequence. All images should have the same type and
size.
@param imgToDenoiseIndex Target image to denoise index in srcImgs sequence
@param temporalWindowSize Number of surrounding images to use for target image denoising. Should
be odd. Images from imgToDenoiseIndex - temporalWindowSize / 2 to
imgToDenoiseIndex - temporalWindowSize / 2 from srcImgs will be used to denoise
srcImgs[imgToDenoiseIndex] image.
@param dst Output image with the same size and type as srcImgs images.
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Parameter regulating filter strength. Bigger h value
perfectly removes noise but also removes image details, smaller h
value preserves details but also preserves some noise
 */
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
        int imgToDenoiseIndex, int temporalWindowSize,
        float h/*=3*/, int templateWindowSize/*=7*/, int searchWindowSize/*=21*/);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
        int imgToDenoiseIndex, int temporalWindowSize);

/** \brief Modification of fastNlMeansDenoising function for images sequence where consequtive images have been
captured in small period of time. For example video. This version of the function is for grayscale
images or for manual manipulation with colorspaces. For more details see
<http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.131.6394>
<p>
@param srcImgs Input 8-bit or 16-bit (only with NORM_L1) 1-channel,
2-channel, 3-channel or 4-channel images sequence. All images should
have the same type and size.
@param imgToDenoiseIndex Target image to denoise index in srcImgs sequence
@param temporalWindowSize Number of surrounding images to use for target image denoising. Should
be odd. Images from imgToDenoiseIndex - temporalWindowSize / 2 to
imgToDenoiseIndex - temporalWindowSize / 2 from srcImgs will be used to denoise
srcImgs[imgToDenoiseIndex] image.
@param dst Output image with the same size and type as srcImgs images.
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Array of parameters regulating filter strength, either one
parameter applied to all channels or one per channel in dst. Big h value
perfectly removes noise but also removes image details, smaller h
value preserves details but also preserves some noise
@param normType Type of norm used for weight calculation. Can be either NORM_L2 or NORM_L1
 */
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector FloatPointer h,
                                             int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                             int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector FloatPointer h);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector FloatBuffer h,
                                             int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                             int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector FloatBuffer h);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector float[] h,
                                             int templateWindowSize/*=7*/, int searchWindowSize/*=21*/,
                                             int normType/*=cv::NORM_L2*/);
@Namespace("cv") public static native void fastNlMeansDenoisingMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
                                             int imgToDenoiseIndex, int temporalWindowSize,
                                             @StdVector float[] h);

/** \brief Modification of fastNlMeansDenoisingMulti function for colored images sequences
<p>
@param srcImgs Input 8-bit 3-channel images sequence. All images should have the same type and
size.
@param imgToDenoiseIndex Target image to denoise index in srcImgs sequence
@param temporalWindowSize Number of surrounding images to use for target image denoising. Should
be odd. Images from imgToDenoiseIndex - temporalWindowSize / 2 to
imgToDenoiseIndex - temporalWindowSize / 2 from srcImgs will be used to denoise
srcImgs[imgToDenoiseIndex] image.
@param dst Output image with the same size and type as srcImgs images.
@param templateWindowSize Size in pixels of the template patch that is used to compute weights.
Should be odd. Recommended value 7 pixels
@param searchWindowSize Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater searchWindowsSize - greater
denoising time. Recommended value 21 pixels
@param h Parameter regulating filter strength for luminance component. Bigger h value perfectly
removes noise but also removes image details, smaller h value preserves details but also preserves
some noise.
@param hColor The same as h but for color components.
<p>
The function converts images to CIELAB colorspace and then separately denoise L and AB components
with given h parameters using fastNlMeansDenoisingMulti function.
 */
@Namespace("cv") public static native void fastNlMeansDenoisingColoredMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
        int imgToDenoiseIndex, int temporalWindowSize,
        float h/*=3*/, float hColor/*=3*/,
        int templateWindowSize/*=7*/, int searchWindowSize/*=21*/);
@Namespace("cv") public static native void fastNlMeansDenoisingColoredMulti( @ByVal MatVector srcImgs, @ByVal Mat dst,
        int imgToDenoiseIndex, int temporalWindowSize);

/** \brief Primal-dual algorithm is an algorithm for solving special types of variational problems (that is,
finding a function to minimize some functional). As the image denoising, in particular, may be seen
as the variational problem, primal-dual algorithm then can be used to perform denoising and this is
exactly what is implemented.
<p>
It should be noted, that this implementation was taken from the July 2013 blog entry
\cite MA13 , which also contained (slightly more general) ready-to-use source code on Python.
Subsequently, that code was rewritten on C++ with the usage of openCV by Vadim Pisarevsky at the end
of July 2013 and finally it was slightly adapted by later authors.
<p>
Although the thorough discussion and justification of the algorithm involved may be found in
\cite ChambolleEtAl, it might make sense to skim over it here, following \cite MA13 . To begin
with, we consider the 1-byte gray-level images as the functions from the rectangular domain of
pixels (it may be seen as set
\f$\left\{(x,y)\in\mathbb{N}\times\mathbb{N}\mid 1\leq x\leq n,\;1\leq y\leq m\right\}\f$ for some
\f$m,\;n\in\mathbb{N}\f$) into \f$\{0,1,\dots,255\}\f$. We shall denote the noised images as \f$f_i\f$ and with
this view, given some image \f$x\f$ of the same size, we may measure how bad it is by the formula
<p>
\f[\left\|\left\|\nabla x\right\|\right\| + \lambda\sum_i\left\|\left\|x-f_i\right\|\right\|\f]
<p>
\f$\|\|\cdot\|\|\f$ here denotes \f$L_2\f$-norm and as you see, the first addend states that we want our
image to be smooth (ideally, having zero gradient, thus being constant) and the second states that
we want our result to be close to the observations we've got. If we treat \f$x\f$ as a function, this is
exactly the functional what we seek to minimize and here the Primal-Dual algorithm comes into play.
<p>
@param observations This array should contain one or more noised versions of the image that is to
be restored.
@param result Here the denoised image will be stored. There is no need to do pre-allocation of
storage space, as it will be automatically allocated, if necessary.
@param lambda Corresponds to \f$\lambda\f$ in the formulas above. As it is enlarged, the smooth
(blurred) images are treated more favorably than detailed (but maybe more noised) ones. Roughly
speaking, as it becomes smaller, the result will be more blur but more sever outliers will be
removed.
@param niters Number of iterations that the algorithm will run. Of course, as more iterations as
better, but it is hard to quantitatively refine this statement, so just use the default and
increase it if the results are poor.
 */
@Namespace("cv") public static native void denoise_TVL1(@Const @ByRef MatVector observations,@ByRef Mat result, double lambda/*=1.0*/, int niters/*=30*/);
@Namespace("cv") public static native void denoise_TVL1(@Const @ByRef MatVector observations,@ByRef Mat result);

/** \} photo_denoise
 <p>
 *  \addtogroup photo_hdr
 *  \{ */

/** enum cv:: */
public static final int LDR_SIZE = 256;

/** \brief Base class for tonemapping algorithms - tools that are used to map HDR image to 8-bit range.
 */
@Namespace("cv") public static class Tonemap extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Tonemap(Pointer p) { super(p); }

    /** \brief Tonemaps image
    <p>
    @param src source image - 32-bit 3-channel Mat
    @param dst destination image - 32-bit 3-channel Mat with values in [0, 1] range
     */
    public native void process(@ByVal Mat src, @ByVal Mat dst);

    public native float getGamma();
    public native void setGamma(float gamma);
}

/** \brief Creates simple linear mapper with gamma correction
<p>
@param gamma positive value for gamma correction. Gamma value of 1.0 implies no correction, gamma
equal to 2.2f is suitable for most displays.
Generally gamma \> 1 brightens the image and gamma \< 1 darkens it.
 */
@Namespace("cv") public static native @Ptr Tonemap createTonemap(float gamma/*=1.0f*/);
@Namespace("cv") public static native @Ptr Tonemap createTonemap();

/** \brief Adaptive logarithmic mapping is a fast global tonemapping algorithm that scales the image in
logarithmic domain.
<p>
Since it's a global operator the same function is applied to all the pixels, it is controlled by the
bias parameter.
<p>
Optional saturation enhancement is possible as described in \cite FL02 .
<p>
For more information see \cite DM03 .
 */
@Namespace("cv") public static class TonemapDrago extends Tonemap {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TonemapDrago(Pointer p) { super(p); }


    public native float getSaturation();
    public native void setSaturation(float saturation);

    public native float getBias();
    public native void setBias(float bias);
}

/** \brief Creates TonemapDrago object
<p>
@param gamma gamma value for gamma correction. See createTonemap
@param saturation positive saturation enhancement value. 1.0 preserves saturation, values greater
than 1 increase saturation and values less than 1 decrease it.
@param bias value for bias function in [0, 1] range. Values from 0.7 to 0.9 usually give best
results, default value is 0.85.
 */
@Namespace("cv") public static native @Ptr TonemapDrago createTonemapDrago(float gamma/*=1.0f*/, float saturation/*=1.0f*/, float bias/*=0.85f*/);
@Namespace("cv") public static native @Ptr TonemapDrago createTonemapDrago();

/** \brief This algorithm decomposes image into two layers: base layer and detail layer using bilateral filter
and compresses contrast of the base layer thus preserving all the details.
<p>
This implementation uses regular bilateral filter from opencv.
<p>
Saturation enhancement is possible as in ocvTonemapDrago.
<p>
For more information see \cite DD02 .
 */
@Namespace("cv") public static class TonemapDurand extends Tonemap {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TonemapDurand(Pointer p) { super(p); }


    public native float getSaturation();
    public native void setSaturation(float saturation);

    public native float getContrast();
    public native void setContrast(float contrast);

    public native float getSigmaSpace();
    public native void setSigmaSpace(float sigma_space);

    public native float getSigmaColor();
    public native void setSigmaColor(float sigma_color);
}

/** \brief Creates TonemapDurand object
<p>
@param gamma gamma value for gamma correction. See createTonemap
@param contrast resulting contrast on logarithmic scale, i. e. log(max / min), where max and min
are maximum and minimum luminance values of the resulting image.
@param saturation saturation enhancement value. See createTonemapDrago
@param sigma_space bilateral filter sigma in color space
@param sigma_color bilateral filter sigma in coordinate space
 */
@Namespace("cv") public static native @Ptr TonemapDurand createTonemapDurand(float gamma/*=1.0f*/, float contrast/*=4.0f*/, float saturation/*=1.0f*/, float sigma_space/*=2.0f*/, float sigma_color/*=2.0f*/);
@Namespace("cv") public static native @Ptr TonemapDurand createTonemapDurand();

/** \brief This is a global tonemapping operator that models human visual system.
<p>
Mapping function is controlled by adaptation parameter, that is computed using light adaptation and
color adaptation.
<p>
For more information see \cite RD05 .
 */
@Namespace("cv") public static class TonemapReinhard extends Tonemap {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TonemapReinhard(Pointer p) { super(p); }

    public native float getIntensity();
    public native void setIntensity(float intensity);

    public native float getLightAdaptation();
    public native void setLightAdaptation(float light_adapt);

    public native float getColorAdaptation();
    public native void setColorAdaptation(float color_adapt);
}

/** \brief Creates TonemapReinhard object
<p>
@param gamma gamma value for gamma correction. See createTonemap
@param intensity result intensity in [-8, 8] range. Greater intensity produces brighter results.
@param light_adapt light adaptation in [0, 1] range. If 1 adaptation is based only on pixel
value, if 0 it's global, otherwise it's a weighted mean of this two cases.
@param color_adapt chromatic adaptation in [0, 1] range. If 1 channels are treated independently,
if 0 adaptation level is the same for each channel.
 */
@Namespace("cv") public static native @Ptr TonemapReinhard createTonemapReinhard(float gamma/*=1.0f*/, float intensity/*=0.0f*/, float light_adapt/*=1.0f*/, float color_adapt/*=0.0f*/);
@Namespace("cv") public static native @Ptr TonemapReinhard createTonemapReinhard();

/** \brief This algorithm transforms image to contrast using gradients on all levels of gaussian pyramid,
transforms contrast values to HVS response and scales the response. After this the image is
reconstructed from new contrast values.
<p>
For more information see \cite MM06 .
 */
@Namespace("cv") public static class TonemapMantiuk extends Tonemap {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TonemapMantiuk(Pointer p) { super(p); }

    public native float getScale();
    public native void setScale(float scale);

    public native float getSaturation();
    public native void setSaturation(float saturation);
}

/** \brief Creates TonemapMantiuk object
<p>
@param gamma gamma value for gamma correction. See createTonemap
@param scale contrast scale factor. HVS response is multiplied by this parameter, thus compressing
dynamic range. Values from 0.6 to 0.9 produce best results.
@param saturation saturation enhancement value. See createTonemapDrago
 */
@Namespace("cv") public static native @Ptr TonemapMantiuk createTonemapMantiuk(float gamma/*=1.0f*/, float scale/*=0.7f*/, float saturation/*=1.0f*/);
@Namespace("cv") public static native @Ptr TonemapMantiuk createTonemapMantiuk();

/** \brief The base class for algorithms that align images of the same scene with different exposures
 */
@Namespace("cv") public static class AlignExposures extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AlignExposures(Pointer p) { super(p); }

    /** \brief Aligns images
    <p>
    @param src vector of input images
    @param dst vector of aligned images
    @param times vector of exposure time values for each image
    @param response 256x1 matrix with inverse camera response function for each pixel value, it should
    have the same number of channels as images.
     */
    public native void process(@ByVal MatVector src, @ByRef MatVector dst,
                                     @ByVal Mat times, @ByVal Mat response);
}

/** \brief This algorithm converts images to median threshold bitmaps (1 for pixels brighter than median
luminance and 0 otherwise) and than aligns the resulting bitmaps using bit operations.
<p>
It is invariant to exposure, so exposure values and camera response are not necessary.
<p>
In this implementation new image regions are filled with zeros.
<p>
For more information see \cite GW03 .
 */
@Namespace("cv") public static class AlignMTB extends AlignExposures {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AlignMTB(Pointer p) { super(p); }

    public native void process(@ByVal MatVector src, @ByRef MatVector dst,
                                     @ByVal Mat times, @ByVal Mat response);

    /** \brief Short version of process, that doesn't take extra arguments.
    <p>
    @param src vector of input images
    @param dst vector of aligned images
     */
    public native void process(@ByVal MatVector src, @ByRef MatVector dst);

    /** \brief Calculates shift between two images, i. e. how to shift the second image to correspond it with the
    first.
    <p>
    @param img0 first image
    @param img1 second image
     */
    public native @ByVal Point calculateShift(@ByVal Mat img0, @ByVal Mat img1);
    /** \brief Helper function, that shift Mat filling new regions with zeros.
    <p>
    @param src input image
    @param dst result image
    @param shift shift value
     */
    public native void shiftMat(@ByVal Mat src, @ByVal Mat dst, @Const @ByVal Point shift);
    /** \brief Computes median threshold and exclude bitmaps of given image.
    <p>
    @param img input image
    @param tb median threshold bitmap
    @param eb exclude bitmap
     */
    public native void computeBitmaps(@ByVal Mat img, @ByVal Mat tb, @ByVal Mat eb);

    public native int getMaxBits();
    public native void setMaxBits(int max_bits);

    public native int getExcludeRange();
    public native void setExcludeRange(int exclude_range);

    public native @Cast("bool") boolean getCut();
    public native void setCut(@Cast("bool") boolean value);
}

/** \brief Creates AlignMTB object
<p>
@param max_bits logarithm to the base 2 of maximal shift in each dimension. Values of 5 and 6 are
usually good enough (31 and 63 pixels shift respectively).
@param exclude_range range for exclusion bitmap that is constructed to suppress noise around the
median value.
@param cut if true cuts images, otherwise fills the new regions with zeros.
 */
@Namespace("cv") public static native @Ptr AlignMTB createAlignMTB(int max_bits/*=6*/, int exclude_range/*=4*/, @Cast("bool") boolean cut/*=true*/);
@Namespace("cv") public static native @Ptr AlignMTB createAlignMTB();

/** \brief The base class for camera response calibration algorithms.
 */
@Namespace("cv") public static class CalibrateCRF extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CalibrateCRF(Pointer p) { super(p); }

    /** \brief Recovers inverse camera response.
    <p>
    @param src vector of input images
    @param dst 256x1 matrix with inverse camera response function
    @param times vector of exposure time values for each image
     */
    public native void process(@ByVal MatVector src, @ByVal Mat dst, @ByVal Mat times);
}

/** \brief Inverse camera response function is extracted for each brightness value by minimizing an objective
function as linear system. Objective function is constructed using pixel values on the same position
in all images, extra term is added to make the result smoother.
<p>
For more information see \cite DM97 .
 */
@Namespace("cv") public static class CalibrateDebevec extends CalibrateCRF {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CalibrateDebevec(Pointer p) { super(p); }

    public native float getLambda();
    public native void setLambda(float lambda);

    public native int getSamples();
    public native void setSamples(int samples);

    public native @Cast("bool") boolean getRandom();
    public native void setRandom(@Cast("bool") boolean random);
}

/** \brief Creates CalibrateDebevec object
<p>
@param samples number of pixel locations to use
@param lambda smoothness term weight. Greater values produce smoother results, but can alter the
response.
@param random if true sample pixel locations are chosen at random, otherwise the form a
rectangular grid.
 */
@Namespace("cv") public static native @Ptr CalibrateDebevec createCalibrateDebevec(int samples/*=70*/, float lambda/*=10.0f*/, @Cast("bool") boolean random/*=false*/);
@Namespace("cv") public static native @Ptr CalibrateDebevec createCalibrateDebevec();

/** \brief Inverse camera response function is extracted for each brightness value by minimizing an objective
function as linear system. This algorithm uses all image pixels.
<p>
For more information see \cite RB99 .
 */
@Namespace("cv") public static class CalibrateRobertson extends CalibrateCRF {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CalibrateRobertson(Pointer p) { super(p); }

    public native int getMaxIter();
    public native void setMaxIter(int max_iter);

    public native float getThreshold();
    public native void setThreshold(float threshold);

    public native @ByVal Mat getRadiance();
}

/** \brief Creates CalibrateRobertson object
<p>
@param max_iter maximal number of Gauss-Seidel solver iterations.
@param threshold target difference between results of two successive steps of the minimization.
 */
@Namespace("cv") public static native @Ptr CalibrateRobertson createCalibrateRobertson(int max_iter/*=30*/, float threshold/*=0.01f*/);
@Namespace("cv") public static native @Ptr CalibrateRobertson createCalibrateRobertson();

/** \brief The base class algorithms that can merge exposure sequence to a single image.
 */
@Namespace("cv") public static class MergeExposures extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MergeExposures(Pointer p) { super(p); }

    /** \brief Merges images.
    <p>
    @param src vector of input images
    @param dst result image
    @param times vector of exposure time values for each image
    @param response 256x1 matrix with inverse camera response function for each pixel value, it should
    have the same number of channels as images.
     */
    public native void process(@ByVal MatVector src, @ByVal Mat dst,
                                     @ByVal Mat times, @ByVal Mat response);
}

/** \brief The resulting HDR image is calculated as weighted average of the exposures considering exposure
values and camera response.
<p>
For more information see \cite DM97 .
 */
@Namespace("cv") public static class MergeDebevec extends MergeExposures {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MergeDebevec(Pointer p) { super(p); }

    public native void process(@ByVal MatVector src, @ByVal Mat dst,
                                     @ByVal Mat times, @ByVal Mat response);
    public native void process(@ByVal MatVector src, @ByVal Mat dst, @ByVal Mat times);
}

/** \brief Creates MergeDebevec object
 */
@Namespace("cv") public static native @Ptr MergeDebevec createMergeDebevec();

/** \brief Pixels are weighted using contrast, saturation and well-exposedness measures, than images are
combined using laplacian pyramids.
<p>
The resulting image weight is constructed as weighted average of contrast, saturation and
well-exposedness measures.
<p>
The resulting image doesn't require tonemapping and can be converted to 8-bit image by multiplying
by 255, but it's recommended to apply gamma correction and/or linear tonemapping.
<p>
For more information see \cite MK07 .
 */
@Namespace("cv") public static class MergeMertens extends MergeExposures {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MergeMertens(Pointer p) { super(p); }

    public native void process(@ByVal MatVector src, @ByVal Mat dst,
                                     @ByVal Mat times, @ByVal Mat response);
    /** \brief Short version of process, that doesn't take extra arguments.
    <p>
    @param src vector of input images
    @param dst result image
     */
    public native void process(@ByVal MatVector src, @ByVal Mat dst);

    public native float getContrastWeight();
    public native void setContrastWeight(float contrast_weiht);

    public native float getSaturationWeight();
    public native void setSaturationWeight(float saturation_weight);

    public native float getExposureWeight();
    public native void setExposureWeight(float exposure_weight);
}

/** \brief Creates MergeMertens object
<p>
@param contrast_weight contrast measure weight. See MergeMertens.
@param saturation_weight saturation measure weight
@param exposure_weight well-exposedness measure weight
 */
@Namespace("cv") public static native @Ptr MergeMertens createMergeMertens(float contrast_weight/*=1.0f*/, float saturation_weight/*=1.0f*/, float exposure_weight/*=0.0f*/);
@Namespace("cv") public static native @Ptr MergeMertens createMergeMertens();

/** \brief The resulting HDR image is calculated as weighted average of the exposures considering exposure
values and camera response.
<p>
For more information see \cite RB99 .
 */
@Namespace("cv") public static class MergeRobertson extends MergeExposures {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MergeRobertson(Pointer p) { super(p); }

    public native void process(@ByVal MatVector src, @ByVal Mat dst,
                                     @ByVal Mat times, @ByVal Mat response);
    public native void process(@ByVal MatVector src, @ByVal Mat dst, @ByVal Mat times);
}

/** \brief Creates MergeRobertson object
 */
@Namespace("cv") public static native @Ptr MergeRobertson createMergeRobertson();

/** \} photo_hdr
<p>
/** \brief Transforms a color image to a grayscale image. It is a basic tool in digital printing, stylized
black-and-white photograph rendering, and in many single channel image processing applications
\cite CL12 .
<p>
@param src Input 8-bit 3-channel image.
@param grayscale Output 8-bit 1-channel image.
@param color_boost Output 8-bit 3-channel image.
<p>
This function is to be applied on color images.
 */
@Namespace("cv") public static native void decolor( @ByVal Mat src, @ByVal Mat grayscale, @ByVal Mat color_boost);

/** \addtogroup photo_clone
 *  \{
<p>
/** \brief Image editing tasks concern either global changes (color/intensity corrections, filters,
deformations) or local changes concerned to a selection. Here we are interested in achieving local
changes, ones that are restricted to a region manually selected (ROI), in a seamless and effortless
manner. The extent of the changes ranges from slight distortions to complete replacement by novel
content \cite PM03 .
<p>
@param src Input 8-bit 3-channel image.
@param dst Input 8-bit 3-channel image.
@param mask Input 8-bit 1 or 3-channel image.
@param p Point in dst image where object is placed.
@param blend Output image with the same size and type as dst.
@param flags Cloning method that could be one of the following:
-   **NORMAL_CLONE** The power of the method is fully expressed when inserting objects with
complex outlines into a new background
-   **MIXED_CLONE** The classic method, color-based selection and alpha masking might be time
consuming and often leaves an undesirable halo. Seamless cloning, even averaged with the
original image, is not effective. Mixed seamless cloning based on a loose selection proves
effective.
-   **FEATURE_EXCHANGE** Feature exchange allows the user to easily replace certain features of
one object by alternative features.
 */
@Namespace("cv") public static native void seamlessClone( @ByVal Mat src, @ByVal Mat dst, @ByVal Mat mask, @ByVal Point p,
        @ByVal Mat blend, int flags);

/** \brief Given an original color image, two differently colored versions of this image can be mixed
seamlessly.
<p>
@param src Input 8-bit 3-channel image.
@param mask Input 8-bit 1 or 3-channel image.
@param dst Output image with the same size and type as src .
@param red_mul R-channel multiply factor.
@param green_mul G-channel multiply factor.
@param blue_mul B-channel multiply factor.
<p>
Multiplication factor is between .5 to 2.5.
 */
@Namespace("cv") public static native void colorChange(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst, float red_mul/*=1.0f*/,
        float green_mul/*=1.0f*/, float blue_mul/*=1.0f*/);
@Namespace("cv") public static native void colorChange(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst);

/** \brief Applying an appropriate non-linear transformation to the gradient field inside the selection and
then integrating back with a Poisson solver, modifies locally the apparent illumination of an image.
<p>
@param src Input 8-bit 3-channel image.
@param mask Input 8-bit 1 or 3-channel image.
@param dst Output image with the same size and type as src.
@param alpha Value ranges between 0-2.
@param beta Value ranges between 0-2.
<p>
This is useful to highlight under-exposed foreground objects or to reduce specular reflections.
 */
@Namespace("cv") public static native void illuminationChange(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst,
        float alpha/*=0.2f*/, float beta/*=0.4f*/);
@Namespace("cv") public static native void illuminationChange(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst);

/** \brief By retaining only the gradients at edge locations, before integrating with the Poisson solver, one
washes out the texture of the selected region, giving its contents a flat aspect. Here Canny Edge
Detector is used.
<p>
@param src Input 8-bit 3-channel image.
@param mask Input 8-bit 1 or 3-channel image.
@param dst Output image with the same size and type as src.
@param low_threshold Range from 0 to 100.
@param high_threshold Value \> 100.
@param kernel_size The size of the Sobel kernel to be used.
<p>
**NOTE:**
<p>
The algorithm assumes that the color of the source image is close to that of the destination. This
assumption means that when the colors don't match, the source image color gets tinted toward the
color of the destination image.
 */
@Namespace("cv") public static native void textureFlattening(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst,
        float low_threshold/*=30*/, float high_threshold/*=45*/,
        int kernel_size/*=3*/);
@Namespace("cv") public static native void textureFlattening(@ByVal Mat src, @ByVal Mat mask, @ByVal Mat dst);

/** \} photo_clone
 <p>
 *  \addtogroup photo_render
 *  \{
<p>
/** \brief Filtering is the fundamental operation in image and video processing. Edge-preserving smoothing
filters are used in many different applications \cite EM11 .
<p>
@param src Input 8-bit 3-channel image.
@param dst Output 8-bit 3-channel image.
@param flags Edge preserving filters:
-   **RECURS_FILTER** = 1
-   **NORMCONV_FILTER** = 2
@param sigma_s Range between 0 to 200.
@param sigma_r Range between 0 to 1.
 */
@Namespace("cv") public static native void edgePreservingFilter(@ByVal Mat src, @ByVal Mat dst, int flags/*=1*/,
        float sigma_s/*=60*/, float sigma_r/*=0.4f*/);
@Namespace("cv") public static native void edgePreservingFilter(@ByVal Mat src, @ByVal Mat dst);

/** \brief This filter enhances the details of a particular image.
<p>
@param src Input 8-bit 3-channel image.
@param dst Output image with the same size and type as src.
@param sigma_s Range between 0 to 200.
@param sigma_r Range between 0 to 1.
 */
@Namespace("cv") public static native void detailEnhance(@ByVal Mat src, @ByVal Mat dst, float sigma_s/*=10*/,
        float sigma_r/*=0.15f*/);
@Namespace("cv") public static native void detailEnhance(@ByVal Mat src, @ByVal Mat dst);

/** \brief Pencil-like non-photorealistic line drawing
<p>
@param src Input 8-bit 3-channel image.
@param dst1 Output 8-bit 1-channel image.
@param dst2 Output image with the same size and type as src.
@param sigma_s Range between 0 to 200.
@param sigma_r Range between 0 to 1.
@param shade_factor Range between 0 to 0.1.
 */
@Namespace("cv") public static native void pencilSketch(@ByVal Mat src, @ByVal Mat dst1, @ByVal Mat dst2,
        float sigma_s/*=60*/, float sigma_r/*=0.07f*/, float shade_factor/*=0.02f*/);
@Namespace("cv") public static native void pencilSketch(@ByVal Mat src, @ByVal Mat dst1, @ByVal Mat dst2);

/** \brief Stylization aims to produce digital imagery with a wide variety of effects not focused on
photorealism. Edge-aware filters are ideal for stylization, as they can abstract regions of low
contrast while preserving, or enhancing, high-contrast features.
<p>
@param src Input 8-bit 3-channel image.
@param dst Output image with the same size and type as src.
@param sigma_s Range between 0 to 200.
@param sigma_r Range between 0 to 1.
 */
@Namespace("cv") public static native void stylization(@ByVal Mat src, @ByVal Mat dst, float sigma_s/*=60*/,
        float sigma_r/*=0.45f*/);
@Namespace("cv") public static native void stylization(@ByVal Mat src, @ByVal Mat dst);

/** \} photo_render
 <p>
 *  \} photo */

 // cv

// #ifndef DISABLE_OPENCV_24_COMPATIBILITY
// #include "opencv2/photo/photo_c.h"
// #endif

// #endif


// Parsed from <opencv2/photo/cuda.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2008-2012, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_PHOTO_CUDA_HPP__
// #define __OPENCV_PHOTO_CUDA_HPP__

// #include "opencv2/core/cuda.hpp"

/** \addtogroup photo_denoise
 *  \{
<p>
/** \brief Performs pure non local means denoising without any simplification, and thus it is not fast.
<p>
@param src Source image. Supports only CV_8UC1, CV_8UC2 and CV_8UC3.
@param dst Destination image.
@param h Filter sigma regulating filter strength for color.
@param search_window Size of search window.
@param block_size Size of block used for computing weights.
@param borderMode Border type. See borderInterpolate for details. BORDER_REFLECT101 ,
BORDER_REPLICATE , BORDER_CONSTANT , BORDER_REFLECT and BORDER_WRAP are supported for now.
@param stream Stream for the asynchronous version.
<p>
\sa
   fastNlMeansDenoising
 */
@Namespace("cv::cuda") public static native void nonLocalMeans(@ByVal Mat src, @ByVal Mat dst,
                              float h,
                              int search_window/*=21*/,
                              int block_size/*=7*/,
                              int borderMode/*=cv::BORDER_DEFAULT*/,
                              @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream/*=cv::cuda::Stream::Null()*/);
@Namespace("cv::cuda") public static native void nonLocalMeans(@ByVal Mat src, @ByVal Mat dst,
                              float h);

/** \brief Perform image denoising using Non-local Means Denoising algorithm
<http://www.ipol.im/pub/algo/bcm_non_local_means_denoising> with several computational
optimizations. Noise expected to be a gaussian white noise
<p>
@param src Input 8-bit 1-channel, 2-channel or 3-channel image.
@param dst Output image with the same size and type as src .
@param h Parameter regulating filter strength. Big h value perfectly removes noise but also
removes image details, smaller h value preserves details but also preserves some noise
@param search_window Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater search_window - greater
denoising time. Recommended value 21 pixels
@param block_size Size in pixels of the template patch that is used to compute weights. Should be
odd. Recommended value 7 pixels
@param stream Stream for the asynchronous invocations.
<p>
This function expected to be applied to grayscale images. For colored images look at
FastNonLocalMeansDenoising::labMethod.
<p>
\sa
   fastNlMeansDenoising
 */
@Namespace("cv::cuda") public static native void fastNlMeansDenoising(@ByVal Mat src, @ByVal Mat dst,
                                     float h,
                                     int search_window/*=21*/,
                                     int block_size/*=7*/,
                                     @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream/*=cv::cuda::Stream::Null()*/);
@Namespace("cv::cuda") public static native void fastNlMeansDenoising(@ByVal Mat src, @ByVal Mat dst,
                                     float h);

/** \brief Modification of fastNlMeansDenoising function for colored images
<p>
@param src Input 8-bit 3-channel image.
@param dst Output image with the same size and type as src .
@param h_luminance Parameter regulating filter strength. Big h value perfectly removes noise but
also removes image details, smaller h value preserves details but also preserves some noise
@param photo_render float The same as h but for color components. For most images value equals 10 will be
enough to remove colored noise and do not distort colors
@param search_window Size in pixels of the window that is used to compute weighted average for
given pixel. Should be odd. Affect performance linearly: greater search_window - greater
denoising time. Recommended value 21 pixels
@param block_size Size in pixels of the template patch that is used to compute weights. Should be
odd. Recommended value 7 pixels
@param stream Stream for the asynchronous invocations.
<p>
The function converts image to CIELAB colorspace and then separately denoise L and AB components
with given h parameters using FastNonLocalMeansDenoising::simpleMethod function.
<p>
\sa
   fastNlMeansDenoisingColored
 */
@Namespace("cv::cuda") public static native void fastNlMeansDenoisingColored(@ByVal Mat src, @ByVal Mat dst,
                                            float h_luminance, float photo_render,
                                            int search_window/*=21*/,
                                            int block_size/*=7*/,
                                            @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream/*=cv::cuda::Stream::Null()*/);
@Namespace("cv::cuda") public static native void fastNlMeansDenoisingColored(@ByVal Mat src, @ByVal Mat dst,
                                            float h_luminance, float photo_render);

/** \} photo */

 // namespace cv { namespace cuda {

// #endif /* __OPENCV_PHOTO_CUDA_HPP__ */


}
