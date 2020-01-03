
var x_offset = 40;
var y_offset =20;
var width = view_hport[0];

var bar_width = sprite_get_width(spr_bar_frame);
var bar_height = sprite_get_height(spr_bar_frame);



draw_sprite_ext(spr_bar_frame, 0, x_offset-30,y_offset+120,2,2,0,c_red,1)
draw_sprite_part_ext(spr_bar_back, 1, 0,0,bar_width*(p1.hp/p1.hp_max),bar_height,x_offset-30, y_offset+120,2,2,c_red,1)
draw_text(x_offset-30,y_offset+160,p1.hp);

draw_sprite_ext(spr_bar_frame, 0, width-x_offset+400,y_offset+120,-2,2,0,c_red,1)
draw_sprite_part_ext(spr_bar_back, 1, 0,0,bar_width*(p2.hp/p2.hp_max),bar_height,width-x_offset+400, y_offset+120,-2,2,c_red,1)
draw_text(width-x_offset+350,y_offset+160,p2.hp);

