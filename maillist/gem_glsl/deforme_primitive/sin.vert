uniform float time;

void main(void)
	{

	gl_FrontColor = gl_Color;
		vec4 v = vec4(gl_Vertex);
	v.z = v.z * sin(5.0*v.x + time*0.1);		
		
		gl_Position = gl_ModelViewProjectionMatrix * v;
	} 
