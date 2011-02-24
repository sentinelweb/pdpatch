uniform float f1, f2, f3, a1, a2, a3, t1, t2, t3;

void main(void)
	{
	vec4 v = vec4(gl_Vertex);
	float facteur;

	facteur = 1. ;
	facteur += a1 * sin(t1 + f1*v.z);
	facteur += a2 * sin(t2 + f2*v.y);
	facteur += a3 * sin(t3 + f3*v.x);

	facteur = max (0.,facteur) ;

	v *= vec4(facteur,facteur,facteur,1.);

	vec3 Normal = normalize(gl_NormalMatrix * v.xyz);

	gl_FrontColor = gl_Color  * 0.2 + 0.7 * dot(Normal,vec3(0.,0.3,0.8));
		
	gl_Position = gl_ModelViewProjectionMatrix * v;
	} 
