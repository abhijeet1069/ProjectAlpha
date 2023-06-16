export default class Vector3D { //dafault will let us import with using {}
    constructor(x, y, z) {
        this.x = x || 0;
        this.y = y || 0;
        this.z = z || 0;
    }

    add(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
        } else {
            return new Vector3D(this.x + v, this.y + v, this.z + v);
        }
    }

    sub(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
        } else {
            return new Vector3D(this.x - v, this.y - v, this.z - v);
        }
    }

    mult(num) {
        return new Vector3D(this.x * num, this.y * num, this.z * num);
    }

    dot(v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    cross(v) {
        return new Vector3D(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }

    length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    unit() {
        const len = this.length();
        return new Vector3D(this.x / len, this.y / len, this.z / len);
    }

    limit(num){
        const length = this.length();
        if(length > num){
            return this.unit().mult(num);
        }
        return this;
    }

    toString(){
        return `x: ${this.x}, y: ${this.y}, z: ${this.z}`;
    }
}
