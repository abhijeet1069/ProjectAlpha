export default class Vector3D {
    constructor(x, y, z) {
        this.x = x || 0;
        this.y = y || 0;
        this.z = z || 0;
    }

    negative() {
        return new Vector3D(-this.x, -this.y, -this.z);
    }

    add(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
        } else {
            return new Vector3D(this.x + v, this.y + v, this.z + v);
        }
    }

    subtract(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
        } else {
            return new Vector3D(this.x - v, this.y - v, this.z - v);
        }
    }

    multiply(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x * v.x, this.y * v.y, this.z * v.z);
        } else {
            return new Vector3D(this.x * v, this.y * v, this.z * v);
        }
    }

    divide(v) {
        if (v instanceof Vector3D) {
            return new Vector3D(this.x / v.x, this.y / v.y, this.z / v.z);
        } else {
            return new Vector3D(this.x / v, this.y / v, this.z / v);
        }
    }

    equals(v) {
        return this.x === v.x && this.y === v.y && this.z === v.z;
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

    min() {
        return Math.min(this.x, this.y, this.z);
    }

    max() {
        return Math.max(this.x, this.y, this.z);
    }

    toAngles() {
        return {
            theta: Math.atan2(this.y, this.x),
            phi: Math.acos(this.z / this.length())
        };
    }

    angleTo(a) {
        return Math.acos(this.dot(a) / (this.length() * a.length()));
    }

    toArray(n) {
        return [this.x, this.y, this.z].slice(0, n || 3);
    }

    clone() {
        return new Vector3D(this.x, this.y, this.z);
    }
    static fromAngles(theta, phi) {
        return new Vector3D(
            Math.cos(theta) * Math.cos(phi),
            Math.sin(phi),
            Math.sin(theta) * Math.cos(phi)
        );
    }

    static randomDirection() {
        return Vector3D.fromAngles(
            Math.random() * Math.PI * 2,
            Math.asin(Math.random() * 2 - 1)
        );
    }

    static lerp(a, b, fraction) {
        return b.subtract(a).multiply(fraction).add(a);
    }

    static fromArray(a) {
        return new Vector3D(a[0], a[1], a[2]);
    }

    static angleBetween(a, b) {
        return a.angleTo(b);
    }
}
