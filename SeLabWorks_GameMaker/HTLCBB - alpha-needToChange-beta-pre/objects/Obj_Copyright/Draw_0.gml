/// @description Insert description here
// You can write your code in this editor
if(room == rm_copyright)
{
	draw_set_halign(fa_middle);
	draw_set_valign(fa_middle);
	draw_set_font(fnt_Copyright);
	draw_set_color(c_red);
	draw_set_alpha(1)

	draw_text(room_width/2,y,string(copyright[0]))

	draw_text(room_width/2,y+300,string(copyright[1]))
	
	draw_sprite(sprite_index,0,room_width/2,y+130)
}



