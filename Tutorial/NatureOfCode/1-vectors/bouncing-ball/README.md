vector.js

1) negative(): Returns the negation of the vector.
2) add(v): Adds the given vector v to the current vector.
3) subtract(v): Subtracts the given vector v from the current vector.
4) multiply(v): Multiplies the current vector by the given vector v or a scalar value.
5) divide(v): Divides the current vector by the given vector v or a scalar value.
6) equals(v): Checks if the current vector is equal to the given vector v.
7) dot(v): Calculates the dot product between the current vector and the given vector v.
8) cross(v): Calculates the cross product between the current vector and the given vector v.
9) length(): Calculates the length (magnitude) of the vector.
10) unit(): Returns a unit vector in the same direction as the current vector.
11) min(): Returns a new vector that represents the component-wise minimum between the current vector and the given  vector v.
12) max(): Returns a new vector that represents the component-wise maximum between the current vector and the given vector v.
13) toAngles(): Converts the vector to spherical coordinates and returns an object with theta (azimuthal angle) and phi (polar angle) properties.
14) angleTo(a): Calculates the angle between the current vector and the given vector a.
15) toArray(n): Converts the vector to an array representation with n (default 3) elements.
16) clone(): Creates a new vector that is a clone of the current vector.
17) init(x, y, z): Initializes the vector with the given x, y, and z coordinates and returns itself.