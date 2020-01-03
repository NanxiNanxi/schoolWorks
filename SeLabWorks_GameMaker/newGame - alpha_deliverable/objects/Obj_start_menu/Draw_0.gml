/// @description Insert description here
// You can write your code in this editor
if(room == rm_start)
{
	draw_set_halign(fa_middle);
	draw_set_valign(fa_middle);
	draw_set_font(fnt_start);
	draw_set_color(c_red);
	draw_set_alpha(1)

	draw_text(room_width/2,y,string(titleString))

	draw_text(room_width/2,y+300,string(menuString))
}