/// @description Insert description here
// You can write your code in this editor

var width = room_width/2;
draw_set_font(fnt_MenuItems);
draw_set_halign(fa_center);

for(var i =0; i < array_length_1d(menu);i++){
	draw_set_color(i==current_index?c_red:c_white);
	draw_text(width, 360+60*i, menu[i]);
}
draw_set_color(c_white);
draw_set_halign(fa_left);