/// @description Insert description here
// You can write your code in this editor
if(room == rm_end)
{
	draw_set_halign(fa_middle);
	draw_set_valign(fa_middle);
	draw_set_font(fnt_MenuItems);
	draw_set_color(c_red);
	

	draw_text(room_width/2,y,string("GAME OVER"))

	draw_text(room_width/2,y+300,string(">>PRESS ENTER TO RESTART<<"))
}