#ifndef DESI_ESP_IMPORTANT_STRUCT_H
#define DESI_ESP_IMPORTANT_STRUCT_H

#include <string>
#define maxplayerCount 100
#define maxvehicleCount 50
#define maxitemsCount 400
#define maxgrenadeCount 10


class Color {
public:
    float r;
    float g;
    float b;
    float a;

    Color() {
        this->r = 0;
        this->g = 0;
        this->b = 0;
        this->a = 0;
    }

    Color(float r, float g, float b, float a) {
        this->r = r;
        this->g = g;
        this->b = b;
        this->a = a;
    }

    Color(float r, float g, float b) {
        this->r = r;
        this->g = g;
        this->b = b;
        this->a = 255;
    }

    static Color White(){
        return Color(255,255,255);
    }

    static Color Green(){
        return Color(0,255,0);
    }
};

class Rect {
public:
    float x;
    float y;
    float width;
    float height;

    Rect() {
        this->x = 0;
        this->y = 0;
        this->width = 0;
        this->height = 0;
    }

    Rect(float x, float y, float width, float height) {
        this->x = x;
        this->y = y;
        this->width = width;
        this->height = height;
    }

    bool operator==(const Rect &src) const {
        return (src.x == this->x && src.y == this->y && src.height == this->height &&
                src.width == this->width);
    }

    bool operator!=(const Rect &src) const {
        return (src.x != this->x && src.y != this->y && src.height != this->height &&
                src.width != this->width);
    }
};

struct Vec3 {
    float x, y, z;
};
class Vec2 {
public:
    float x;
    float y;

    Vec2() {
        this->x = 0;
        this->y = 0;
    }

    Vec2(float x, float y) {
        this->x = x;
        this->y = y;
    }

    static Vec2 Zero() {
        return Vec2(0.0f, 0.0f);
    }

    bool operator!=(const Vec2 &src) const {
        return (src.x != x) || (src.y != y);
    }

    Vec2 &operator+=(const Vec2 &v) {
        x += v.x;
        y += v.y;
        return *this;
    }

    Vec2 &operator-=(const Vec2 &v) {
        x -= v.x;
        y -= v.y;
        return *this;
    }
};
struct PlayerBone {
    bool isBone=false;
    Vec2 neck;
    Vec2 cheast;
    Vec2 pelvis;
    Vec2 lSh;
    Vec2 rSh;
    Vec2 lElb;
    Vec2 rElb;
    Vec2 lWr;
    Vec2 rWr;
    Vec2 lTh;
    Vec2 rTh;
    Vec2 lKn;
    Vec2 rKn;
    Vec2 lAn;
    Vec2 rAn;
};
struct PlayerWeapon {
    bool isWeapon=false;
    int id;
    int ammo;
};
enum Mode {
    InitMode = 1,
    ESPMode = 2,
    HackMode = 3,
    StopMode = 4,
};

struct Request {
    int Mode;
    int ScreenWidth;
    int ScreenHeight;
};

struct SetValue {
    int mode;
    int type;
};

struct VehicleData {
    char VehicleName[50];
    float Distance;
    Vec3 Location;
};

struct ItemData {
    char ItemName[50];
    float Distance;
    Vec3 Location;
};

struct GrenadeData {
    int type;
    float Distance;
    Vec3 Location;
};


struct PlayerData {
    char PlayerNameByte[100];
    int TeamID;
    float Health;
    float Distance;
    bool isBot;
    Vec3 HeadLocation;
    PlayerWeapon Weapon;
    PlayerBone Bone;
};

struct Response {
    bool Success;
    int PlayerCount;
    int VehicleCount;
    int ItemsCount;
    int GrenadeCount;
    float fov;
    PlayerData Players[maxplayerCount];
    VehicleData Vehicles[maxvehicleCount];
    ItemData Items[maxitemsCount];
    GrenadeData Grenade[maxgrenadeCount];
};


#endif //DESI_ESP_IMPORTANT_STRUCT_H
