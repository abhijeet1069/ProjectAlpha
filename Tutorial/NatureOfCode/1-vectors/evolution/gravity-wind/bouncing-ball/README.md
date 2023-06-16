## app.js
> main() -> draw() -> draw()

## helper.js
### Functions
```
getRandomInteger(min, max) - Generates a random integer between min number and max number
```

## vector3d.js
### Classes 
```
class Vector3D{
    x,y,z
    constructor(x,y,z) - Initializes components else set to 0

    add(v) - Add this vector to v vector

    sub(v) - Subtract this vector to v vector

    limit(num) - Set modulus of this vector <= num

    mult(num) - Scalar multiply this vector by nums

    unit() - Normalize given vector

}
````
