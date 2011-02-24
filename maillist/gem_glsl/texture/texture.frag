uniform sampler2DRect MyTex;

void main (void)
{
 vec4 color = texture2DRect(MyTex, gl_TexCoord[0].st);
 color = color* 0.5;
 gl_FragColor = color;
}
