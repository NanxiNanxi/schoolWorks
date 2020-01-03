var owner = argument0;
var damage;
damage = argument1;
var h = instance_create_layer(x,y,"Instances",obj_punch_hitbox);
h.image_xscale = other.image_xscale;

h.owner = owner;
h.damage = damage;
/**var damage, x_offset, y_offset;

x_offset = argument2;
y_offset = argument3;





h.damage = damage;
h.x_offset = x_offset;
h.y_offset = y_offset;**/