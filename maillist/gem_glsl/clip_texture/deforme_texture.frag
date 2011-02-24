uniform float K1,K2,K3;
uniform sampler2D texture;


void main (void)
{
	vec2 txt = gl_TexCoord[0].st ;

	vec4 color = texture2D(texture, txt );

	color.r = smoothstep(K1,K1+0.2,color.r);
	color.r = 1.+(-1.*abs(color.r * 2. -1.0));
	color.g = smoothstep(K2,K2+0.2,color.g);
	color.g = 1.+(-1.*abs(color.g * 2. -1.0));
	color.b = smoothstep(K3,K3+0.2,color.b);
	color.b = 1.+(-1.*abs(color.b * 2. -1.0));

	gl_FragColor = color;

}
