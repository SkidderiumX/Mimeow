package x;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL20;

public class oc595c51c58f {
   private Minecraft Ή = Minecraft.getMinecraft();
   public final int ƌ;
   private final Map<String, Integer> ψ = new HashMap<>();
   private final String ң = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform bool check;\nuniform float lastPass;\nuniform float exposure;\n\nvoid main() {\n    if(check && texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum.rgb *= sum.a;\n    vec4 smpl1 =  texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n    vec4 result = sum / 12.0;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), mix(result.a, 1.0 - exp(-result.a * exposure), step(0.0, lastPass)));\n}";
   private final String ɚ = "#version 120\n\nuniform sampler2D textureIn, textureToCheck;\nuniform vec2 texelSize, direction;\nuniform vec3 color;\nuniform bool avoidTexture;\nuniform float exposure, radius;\nuniform float weights[256];\n\n#define offset direction * texelSize\n\nvoid main() {\n    if (direction.y == 1 && avoidTexture) {\n        if (texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    }\n    vec4 innerColor = texture2D(textureIn, gl_TexCoord[0].st);\n    innerColor.rgb *= innerColor.a;\n    innerColor *= weights[0];\n    for (float r = 1.0; r <= radius; r++) {\n        vec4 colorCurrent1 = texture2D(textureIn, gl_TexCoord[0].st + offset * r);\n        vec4 colorCurrent2 = texture2D(textureIn, gl_TexCoord[0].st - offset * r);\n\n        colorCurrent1.rgb *= colorCurrent1.a;\n        colorCurrent2.rgb *= colorCurrent2.a;\n\n        innerColor += (colorCurrent1 + colorCurrent2) * weights[int(r)];\n    }\n\n    gl_FragColor = vec4(innerColor.rgb / max(innerColor.a, 0.0001), mix(innerColor.a, 1.0 - exp(-innerColor.a * exposure), step(0.0, direction.y)));\n}\n";
   private final String έ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D textureIn;\nuniform float radius, alpha;\n\nfloat roundedBoxSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) -size, 0.)) - radius;\n}\n\n\nvoid main() {\n    float distance = roundedBoxSDF((rectSize * .5) - (gl_TexCoord[0].st * rectSize), (rectSize * .5) - radius - 1., radius);\n    float smoothedAlpha =  (1.0$smoothstep(0.0, 2.0, distance)) * alpha;\n    gl_FragColor = vec4(texture2D(textureIn, gl_TexCoord[0].st).rgb, smoothedAlpha);\n}";
   private final String ϼ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color, outlineColor;\nuniform float radius, outlineThickness;\n\nfloat roundedSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) - size + radius, 0.0)) - radius;\n}\n\nvoid main() {\n    float distance = roundedSDF(gl_FragCoord.xy - location - (rectSize * .5), (rectSize * .5) + (outlineThickness *.5) - 1.0, radius);\n\n    float blendAmount = smoothstep(0., 2., abs(distance) - (outlineThickness * .5));\n\n    vec4 insideColor = (distance < 0.) ? color : vec4(outlineColor.rgb,  0.0);\n    gl_FragColor = mix(outlineColor, insideColor, blendAmount);\n\n}";
   private final String Μ = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec2 offset1 = vec2(-halfpixel.x, 0.0) * offset;\n    vec2 offset2 = vec2(-halfpixel.x, halfpixel.y) * offset;\n    vec2 offset3 = vec2(0.0, halfpixel.y * 2.0) * offset;\n    vec2 offset4 = vec2(halfpixel.x, halfpixel.y) * offset;\n    vec2 offset5 = vec2(halfpixel.x * 2.0, 0.0) * offset;\n    vec2 offset6 = vec2(halfpixel.x, -halfpixel.y) * offset;\n    vec2 offset7 = vec2(0.0, -halfpixel.y * 2.0) * offset;\n    vec2 offset8 = vec2(-halfpixel.x, -halfpixel.y) * offset;\n\n    vec4 sum = texture2D(inTexture, uv + offset1);\n    sum.rgb *= sum.a;\n    vec4 smpl1 = texture2D(inTexture, uv + offset2);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + offset3);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + offset4);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + offset5);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + offset6);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + offset7);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + offset8);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n\n    vec4 result = sum / 12.0;\n    float checkAlpha = texture2D(textureToCheck, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), mix(result.a, result.a * (1.0 - checkAlpha), float(check)));\n}\n";
   private final String ե = "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv);\n    sum.rgb *= sum.a;\n    sum *= 4.0;\n    vec4 smp1 = texture2D(inTexture, uv - halfpixel.xy * offset);\n    smp1.rgb *= smp1.a;\n    sum += smp1;\n    vec4 smp2 = texture2D(inTexture, uv + halfpixel.xy * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3;\n    vec4 smp4 = texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 result = sum / 8.0;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), result.a);\n}\n";
   private final String ĉ = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset) * 2.0;\n\n    vec4 average = sum / 12.0;\n    gl_FragColor = vec4(average.rgb, mix(1.0, texture2D(textureToCheck, gl_TexCoord[0].st).a, check));\n}";
   private final String ѵ = "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv) * 4.0;\n    sum += texture2D(inTexture, uv - halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    sum += texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n\n    gl_FragColor = vec4(sum.rgb * 0.125, 1.0);\n}";
   private final String Ų = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec3 color1, color2, color3, color4;\nuniform float alpha;\n\n#define NOISE .5/255.0\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898,78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(tex, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(createGradient(coords, color1, color2, color3, color4), texColorAlpha * alpha);\n}";
   private final String Θ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D u_texture, u_texture2;\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(u_texture, gl_TexCoord[0].st).a;\n    vec3 tex2Color = texture2D(u_texture2, gl_TexCoord[0].st).rgb;\n    gl_FragColor = vec4(tex2Color, texColorAlpha);\n}";
   private final String ʏ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec4 color1, color2, color3, color4;\n#define NOISE .5/255.0\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    gl_FragColor = createGradient(coords, color1, color2, color3, color4);\n}";
   private final String ß = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0$smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius)));\n    vec4 gradient = createGradient(st, color1, color2, color3, color4);    gl_FragColor = vec4(gradient.rgb, gradient.a * smoothedAlpha);\n}";
   private final String ԍ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    float smoothedAlpha =  (1.0$smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);\n\n}";
   private final String ѧ = "#version 120\n\nuniform vec2 u_size;\nuniform float u_radius;\nuniform vec4 u_color;\nuniform vec4 u_edges;\n\nvoid main(void)\n{\n    vec2 tex_coord = gl_TexCoord[0].st;\n\n    if (tex_coord.x < 0.5 && tex_coord.y > 0.5 && u_edges.x == 0.0 ||\n        tex_coord.x > 0.5 && tex_coord.y > 0.5 && u_edges.y == 0.0 ||\n        tex_coord.x > 0.5 && tex_coord.y < 0.5 && u_edges.z == 0.0 ||\n        tex_coord.x < 0.5 && tex_coord.y < 0.5 && u_edges.w == 0.0) {\n        gl_FragColor = u_color;\n    } else {\n        gl_FragColor = vec4(u_color.rgb, u_color.a * smoothstep(1.0, 0.0, length(max((abs(tex_coord - 0.5) + 0.5) * u_size - u_size + u_radius, 0.0)) - u_radius + 0.5));\n    }\n}";
   public static boolean ĵ;

   public oc595c51c58f(String var1, String var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      try {
         var3 = GL20.glCreateProgram();
         if (var3 == 0) {
            throw new IllegalStateException("Unable to allocate shader program");
         }

         int var7 = -1;
         switch (var1.hashCode()) {
            case -1936678758:
               if (var1.equals("roundedRectRise")) {
                  var7 = -2114606738 ^ -2114606749;
               }
               break;
            case -1432945623:
               if (var1.equals("roundRectTexture")) {
                  var7 = -2114606751 ^ -2114606749;
               }
               break;
            case -1121374384:
               if (var1.equals("roundRectOutline")) {
                  var7 = -2114606752 ^ -2114606749;
               }
               break;
            case -493757311:
               if (var1.equals("roundedRectGradient")) {
                  var7 = -2114606737 ^ -2114606749;
               }
               break;
            case -200552017:
               if (var1.equals("kawaseDownBloom")) {
                  var7 = -2114606746 ^ -2114606749;
               }
               break;
            case -72859087:
               if (var1.equals("roundedRect")) {
                  var7 = -2114606744 ^ -2114606749;
               }
               break;
            case 3175821:
               if (var1.equals("glow")) {
                  var7 = 1;
               }
               break;
            case 3344108:
               if (var1.equals("mask")) {
                  var7 = -2114606742 ^ -2114606749;
               }
               break;
            case 89650992:
               if (var1.equals("gradient")) {
                  var7 = -2114606743 ^ -2114606749;
               }
               break;
            case 491608636:
               if (var1.equals("gradientMask")) {
                  var7 = -2114606741 ^ -2114606749;
               }
               break;
            case 1190632237:
               if (var1.equals("kawaseUp")) {
                  var7 = -2114606747 ^ -2114606749;
               }
               break;
            case 1261448918:
               if (var1.equals("kawaseUpBloom")) {
                  var7 = -2114606745 ^ -2114606749;
               }
               break;
            case 1735775412:
               if (var1.equals("kawaseDown")) {
                  var7 = -2114606748 ^ -2114606749;
               }
               break;
            case 2119050842:
               if (var1.equals("kawaseUpGlow")) {
                  var7 = 0;
               }
         }
         var4 = switch (var7) {
            case 0 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform bool check;\nuniform float lastPass;\nuniform float exposure;\n\nvoid main() {\n    if(check && texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum.rgb *= sum.a;\n    vec4 smpl1 =  texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n    vec4 result = sum / 12.0;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), mix(result.a, 1.0 - exp(-result.a * exposure), step(0.0, lastPass)));\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 1 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D textureIn, textureToCheck;\nuniform vec2 texelSize, direction;\nuniform vec3 color;\nuniform bool avoidTexture;\nuniform float exposure, radius;\nuniform float weights[256];\n\n#define offset direction * texelSize\n\nvoid main() {\n    if (direction.y == 1 && avoidTexture) {\n        if (texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    }\n    vec4 innerColor = texture2D(textureIn, gl_TexCoord[0].st);\n    innerColor.rgb *= innerColor.a;\n    innerColor *= weights[0];\n    for (float r = 1.0; r <= radius; r++) {\n        vec4 colorCurrent1 = texture2D(textureIn, gl_TexCoord[0].st + offset * r);\n        vec4 colorCurrent2 = texture2D(textureIn, gl_TexCoord[0].st - offset * r);\n\n        colorCurrent1.rgb *= colorCurrent1.a;\n        colorCurrent2.rgb *= colorCurrent2.a;\n\n        innerColor += (colorCurrent1 + colorCurrent2) * weights[int(r)];\n    }\n\n    gl_FragColor = vec4(innerColor.rgb / max(innerColor.a, 0.0001), mix(innerColor.a, 1.0 - exp(-innerColor.a * exposure), step(0.0, direction.y)));\n}\n"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 2 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D textureIn;\nuniform float radius, alpha;\n\nfloat roundedBoxSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) -size, 0.)) - radius;\n}\n\n\nvoid main() {\n    float distance = roundedBoxSDF((rectSize * .5) - (gl_TexCoord[0].st * rectSize), (rectSize * .5) - radius - 1., radius);\n    float smoothedAlpha =  (1.0$smoothstep(0.0, 2.0, distance)) * alpha;\n    gl_FragColor = vec4(texture2D(textureIn, gl_TexCoord[0].st).rgb, smoothedAlpha);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 3 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color, outlineColor;\nuniform float radius, outlineThickness;\n\nfloat roundedSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) - size + radius, 0.0)) - radius;\n}\n\nvoid main() {\n    float distance = roundedSDF(gl_FragCoord.xy - location - (rectSize * .5), (rectSize * .5) + (outlineThickness *.5) - 1.0, radius);\n\n    float blendAmount = smoothstep(0., 2., abs(distance) - (outlineThickness * .5));\n\n    vec4 insideColor = (distance < 0.) ? color : vec4(outlineColor.rgb,  0.0);\n    gl_FragColor = mix(outlineColor, insideColor, blendAmount);\n\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 4 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec2 offset1 = vec2(-halfpixel.x, 0.0) * offset;\n    vec2 offset2 = vec2(-halfpixel.x, halfpixel.y) * offset;\n    vec2 offset3 = vec2(0.0, halfpixel.y * 2.0) * offset;\n    vec2 offset4 = vec2(halfpixel.x, halfpixel.y) * offset;\n    vec2 offset5 = vec2(halfpixel.x * 2.0, 0.0) * offset;\n    vec2 offset6 = vec2(halfpixel.x, -halfpixel.y) * offset;\n    vec2 offset7 = vec2(0.0, -halfpixel.y * 2.0) * offset;\n    vec2 offset8 = vec2(-halfpixel.x, -halfpixel.y) * offset;\n\n    vec4 sum = texture2D(inTexture, uv + offset1);\n    sum.rgb *= sum.a;\n    vec4 smpl1 = texture2D(inTexture, uv + offset2);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + offset3);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + offset4);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + offset5);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + offset6);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + offset7);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + offset8);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n\n    vec4 result = sum / 12.0;\n    float checkAlpha = texture2D(textureToCheck, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), mix(result.a, result.a * (1.0 - checkAlpha), float(check)));\n}\n"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 5 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv);\n    sum.rgb *= sum.a;\n    sum *= 4.0;\n    vec4 smp1 = texture2D(inTexture, uv - halfpixel.xy * offset);\n    smp1.rgb *= smp1.a;\n    sum += smp1;\n    vec4 smp2 = texture2D(inTexture, uv + halfpixel.xy * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3;\n    vec4 smp4 = texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 result = sum / 8.0;\n    gl_FragColor = vec4(result.rgb / max(result.a, 0.0001), result.a);\n}\n"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 6 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset) * 2.0;\n\n    vec4 average = sum / 12.0;\n    gl_FragColor = vec4(average.rgb, mix(1.0, texture2D(textureToCheck, gl_TexCoord[0].st).a, check));\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 7 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / iResolution;\n\n    vec4 sum = texture2D(inTexture, uv) * 4.0;\n    sum += texture2D(inTexture, uv - halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    sum += texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n\n    gl_FragColor = vec4(sum.rgb * 0.125, 1.0);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 8 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec3 color1, color2, color3, color4;\nuniform float alpha;\n\n#define NOISE .5/255.0\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898,78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(tex, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(createGradient(coords, color1, color2, color3, color4), texColorAlpha * alpha);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 9 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D u_texture, u_texture2;\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(u_texture, gl_TexCoord[0].st).a;\n    vec3 tex2Color = texture2D(u_texture2, gl_TexCoord[0].st).rgb;\n    gl_FragColor = vec4(tex2Color, texColorAlpha);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 10 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec4 color1, color2, color3, color4;\n#define NOISE .5/255.0\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    gl_FragColor = createGradient(coords, color1, color2, color3, color4);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 11 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    float smoothedAlpha =  (1.0$smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);\n\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 12 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0$smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius)));\n    vec4 gradient = createGradient(st, color1, color2, color3, color4);    gl_FragColor = vec4(gradient.rgb, gradient.a * smoothedAlpha);\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            case 13 -> this.ӫ(
               new ByteArrayInputStream(
                  "#version 120\n\nuniform vec2 u_size;\nuniform float u_radius;\nuniform vec4 u_color;\nuniform vec4 u_edges;\n\nvoid main(void)\n{\n    vec2 tex_coord = gl_TexCoord[0].st;\n\n    if (tex_coord.x < 0.5 && tex_coord.y > 0.5 && u_edges.x == 0.0 ||\n        tex_coord.x > 0.5 && tex_coord.y > 0.5 && u_edges.y == 0.0 ||\n        tex_coord.x > 0.5 && tex_coord.y < 0.5 && u_edges.z == 0.0 ||\n        tex_coord.x < 0.5 && tex_coord.y < 0.5 && u_edges.w == 0.0) {\n        gl_FragColor = u_color;\n    } else {\n        gl_FragColor = vec4(u_color.rgb, u_color.a * smoothstep(1.0, 0.0, length(max((abs(tex_coord - 0.5) + 0.5) * u_size - u_size + u_radius, 0.0)) - u_radius + 0.5));\n    }\n}"
                     .getBytes()
               ),
               -2114641325 ^ -2114606749
            );
            default -> this.z(var1, -2114641325 ^ -2114606749);
         };
         GL20.glAttachShader(var3, var4);
         var5 = this.z(var2, -2114641326 ^ -2114606749);
         GL20.glAttachShader(var3, var5);
         GL20.glLinkProgram(var3);
         if (GL20.glGetProgrami(var3, -2114641183 ^ -2114606749) == 0) {
            throw new IllegalStateException("Shader failed to link: " + GL20.glGetProgramInfoLog(var3, -2114602653 ^ -2114606749));
         }

         this.ƌ = var3;
      } catch (IOException | LinkageError | RuntimeException var11) {
         բ(var3);
         throw new IllegalStateException("Failed to create shader program", var11);
      } finally {
         ѳ(var4);
         ѳ(var5);
      }
   }

   private int z(String var1, int var2) throws IOException {
      InputStream var3 = this.Ή.getResourceManager().getResource(new ResourceLocation(var1)).getInputStream();

      int var4;
      try {
         var4 = this.ӫ(var3, var2);
      } catch (Throwable var8) {
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var6) {
               var8.addSuppressed(var6);
            }
         }

         throw var8;
      }

      try {
         if (var3 != null) {
            var3.close();
         }

         return var4;
      } catch (Throwable var7) {
         throw var7;
      }
   }

   public oc595c51c58f(String var1) {
      this(var1, "minecraft:shaders/vertex.vsh");
   }

   public static void ư() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new net/minecraft/client/gui/ScaledResolution
      // 03: dup
      // 04: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 07: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0a: astore 1
      // 0b: getstatic x/oc1b46ea259e.ǧ Z
      // 0e: aload 1
      // 0f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth_double ()D
      // 12: d2f
      // 13: fstore 2
      // 14: aload 1
      // 15: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight_double ()D
      // 18: d2f
      // 19: fstore 3
      // 1a: ldc_w -1721554890
      // 1d: ldc_w -1721554895
      // 20: ixor
      // 21: invokestatic org/lwjgl/opengl/GL20.glBegin (I)V
      // 24: fconst_0
      // 25: fconst_1
      // 26: invokestatic org/lwjgl/opengl/GL20.glTexCoord2f (FF)V
      // 29: fconst_0
      // 2a: fconst_0
      // 2b: invokestatic org/lwjgl/opengl/GL20.glVertex2f (FF)V
      // 2e: istore 0
      // 2f: fconst_0
      // 30: fconst_0
      // 31: invokestatic org/lwjgl/opengl/GL20.glTexCoord2f (FF)V
      // 34: fconst_0
      // 35: fload 3
      // 36: invokestatic org/lwjgl/opengl/GL20.glVertex2f (FF)V
      // 39: fconst_1
      // 3a: fconst_0
      // 3b: invokestatic org/lwjgl/opengl/GL20.glTexCoord2f (FF)V
      // 3e: fload 2
      // 3f: fload 3
      // 40: invokestatic org/lwjgl/opengl/GL20.glVertex2f (FF)V
      // 43: fconst_1
      // 44: fconst_1
      // 45: invokestatic org/lwjgl/opengl/GL20.glTexCoord2f (FF)V
      // 48: fload 2
      // 49: fconst_0
      // 4a: invokestatic org/lwjgl/opengl/GL20.glVertex2f (FF)V
      // 4d: invokestatic org/lwjgl/opengl/GL20.glEnd ()V
      // 50: iload 0
      // 51: ifeq 65
      // 54: bipush 0
      // 55: ifeq 61
      // 58: goto 5c
      // 5b: athrow
      // 5c: bipush 0
      // 5d: goto 62
      // 60: athrow
      // 61: bipush 1
      // 62: putstatic x/oc69da1aa7f5.Ҭ Z
      // 65: return
   }

   public static void բ(float var0, float var1, float var2, float var3) {
      GL20.glBegin(1442734240 ^ 1442734247);
      GL20.glTexCoord2f(0.0F, 0.0F);
      GL20.glVertex2f(var0, var1);
      GL20.glTexCoord2f(0.0F, 1.0F);
      GL20.glVertex2f(var0, var1 + var3);
      GL20.glTexCoord2f(1.0F, 1.0F);
      GL20.glVertex2f(var0 + var2, var1 + var3);
      GL20.glTexCoord2f(1.0F, 0.0F);
      GL20.glVertex2f(var0 + var2, var1);
      GL20.glEnd();
   }

   public void ǵ() {
      GL20.glUseProgram(this.ƌ);
   }

   public void ʇ() {
      GL20.glUseProgram(0);
   }

   public void ψ(String param1, float... param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual x/oc595c51c58f.L (Ljava/lang/String;)I
      // 08: istore 4
      // 0a: istore 3
      // 0b: iload 4
      // 0d: iload 3
      // 0e: ifne 1d
      // 11: bipush -1
      // 12: if_icmpne 1b
      // 15: goto 19
      // 18: athrow
      // 19: return
      // 1a: athrow
      // 1b: aload 2
      // 1c: arraylength
      // 1d: iload 3
      // 1e: ifne 43
      // 21: tableswitch 124 1 4 32 44 63 91
      // 40: athrow
      // 41: iload 4
      // 43: aload 2
      // 44: bipush 0
      // 45: faload
      // 46: invokestatic org/lwjgl/opengl/GL20.glUniform1f (IF)V
      // 49: iload 3
      // 4a: ifeq 9d
      // 4d: iload 4
      // 4f: aload 2
      // 50: bipush 0
      // 51: faload
      // 52: aload 2
      // 53: bipush 1
      // 54: faload
      // 55: invokestatic org/lwjgl/opengl/GL20.glUniform2f (IFF)V
      // 58: iload 3
      // 59: ifeq 9d
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 4
      // 62: aload 2
      // 63: bipush 0
      // 64: faload
      // 65: aload 2
      // 66: bipush 1
      // 67: faload
      // 68: aload 2
      // 69: ldc_w -2142084517
      // 6c: ldc_w -2142084519
      // 6f: ixor
      // 70: faload
      // 71: invokestatic org/lwjgl/opengl/GL20.glUniform3f (IFFF)V
      // 74: iload 3
      // 75: ifeq 9d
      // 78: goto 7c
      // 7b: athrow
      // 7c: iload 4
      // 7e: aload 2
      // 7f: bipush 0
      // 80: faload
      // 81: aload 2
      // 82: bipush 1
      // 83: faload
      // 84: aload 2
      // 85: ldc_w -2142084517
      // 88: ldc_w -2142084519
      // 8b: ixor
      // 8c: faload
      // 8d: aload 2
      // 8e: ldc_w -2142084518
      // 91: ldc_w -2142084519
      // 94: ixor
      // 95: faload
      // 96: invokestatic org/lwjgl/opengl/GL20.glUniform4f (IFFFF)V
      // 99: goto 9d
      // 9c: athrow
      // 9d: return
   }

   public void ҏ(String param1, int... param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual x/oc595c51c58f.L (Ljava/lang/String;)I
      // 08: istore 4
      // 0a: istore 3
      // 0b: iload 4
      // 0d: iload 3
      // 0e: ifne 1d
      // 11: bipush -1
      // 12: if_icmpne 1b
      // 15: goto 19
      // 18: athrow
      // 19: return
      // 1a: athrow
      // 1b: aload 2
      // 1c: arraylength
      // 1d: iload 3
      // 1e: ifne 42
      // 21: bipush 1
      // 22: if_icmple 3c
      // 25: goto 29
      // 28: athrow
      // 29: iload 4
      // 2b: aload 2
      // 2c: bipush 0
      // 2d: iaload
      // 2e: aload 2
      // 2f: bipush 1
      // 30: iaload
      // 31: invokestatic org/lwjgl/opengl/GL20.glUniform2i (III)V
      // 34: iload 3
      // 35: ifeq 48
      // 38: goto 3c
      // 3b: athrow
      // 3c: iload 4
      // 3e: goto 42
      // 41: athrow
      // 42: aload 2
      // 43: bipush 0
      // 44: iaload
      // 45: invokestatic org/lwjgl/opengl/GL20.glUniform1i (II)V
      // 48: return
   }

   private int L(String var1) {
      boolean var10000 = oc1b46ea259e.ǧ;
      Integer var3 = this.ψ.get(var1);
      boolean var2 = var10000;

      label30: {
         try {
            if (var2) {
               return var3;
            }

            if (var3 == null) {
               break label30;
            }
         } catch (IllegalStateException var5) {
            throw var5;
         }

         return var3;
      }

      int var4 = GL20.glGetUniformLocation(this.ƌ, var1);
      this.ψ.put(var1, var4);
      return var4;
   }

   private int ӫ(InputStream var1, int var2) {
      int var3 = GL20.glCreateShader(var2);

      try {
         if (var3 == 0) {
            throw new IllegalStateException("Unable to allocate shader");
         }
      } catch (IllegalStateException var5) {
         throw var5;
      }

      oc30aea91d28.Տ(var3, oc7ab2161b9f.ǚ(var1));
      GL20.glCompileShader(var3);
      if (GL20.glGetShaderi(var3, 203325958 ^ 203295111) == 0) {
         String var4 = GL20.glGetShaderInfoLog(var3, 203299207 ^ 203295111);
         GL20.glDeleteShader(var3);
         Object[] var10003 = new Object[203295109 ^ 203295111];
         var10003[0] = var2;
         var10003[1] = var4;
         throw new IllegalStateException(String.format("Shader (%s) failed to compile: %s", var10003));
      } else {
         return var3;
      }
   }

   private static void ѳ(int var0) {
      try {
         if (var0 == 0) {
            return;
         }
      } catch (RuntimeException var3) {
         throw var3;
      }

      try {
         GL20.glDeleteShader(var0);
      } catch (LinkageError | RuntimeException var2) {
      }
   }

   private static void բ(int var0) {
      try {
         if (var0 == 0) {
            return;
         }
      } catch (RuntimeException var3) {
         throw var3;
      }

      try {
         GL20.glDeleteProgram(var0);
      } catch (LinkageError | RuntimeException var2) {
      }
   }
}
