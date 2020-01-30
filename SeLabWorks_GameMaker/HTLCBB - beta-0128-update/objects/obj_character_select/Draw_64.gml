/// @description Insert description here
// You can write your code in this editor

var width = room_width/2;
draw_set_font(fnt_instruction);
draw_set_color(c_red);
draw_set_halign(fa_center);

draw_text(width,100,"Select Character")
draw_set_font(fnt_instruction);
draw_set_color(c_white);
draw_text(500,20,"Player1: press w or d to choose a character, press space to confirm")
draw_text(500,45,"Player2: press left or right to choose a character, press enter to confirm")

draw_set_font(fnt_instruction);
draw_set_halign(fa_left);

for(var i = 0; i<CHAR_NUMBER; i++){
	draw_sprite(icons[i],0,400+128*i,200);
	if (i == p1_index){
		draw_set_color(c_green);
		draw_text(375+128*i,170,"Player1");
		draw_set_color(c_white);
	}
	
	if (i == p2_index){
		draw_set_color(c_orange);
		draw_text(375+128*i,284,"Player2");
		draw_set_color(c_white);
	}
	

}

if p1_ready and p2_ready {
	draw_text(width-150, room_height/2+170, "characters choosing finished");
	draw_text(width-150, room_height/2+230, "Start Game: Press SHIFT")
	draw_text(width-150, room_height/2+270, "Main Menu: Press ESCAPE")
	if(max(keyboard_check_pressed(vk_shift),gamepad_button_check_pressed(0,gp_start),0)==1) 
	{
		if (global.isGame1){ room_goto(rm_game)}
		if(global.isGame2){room_goto(rm_game2)};
		
		
		audio_play_sound(bgm_game_start,1000,false);
	}
	if(max(keyboard_check_pressed(vk_escape),0,gamepad_button_check_pressed(0,gp_shoulderlb))) room_goto(rm_main_menu);

}



draw_sprite(images[p1_index],0,width/2-100,room_height/2);
draw_text(width/2-120,room_height/2+135,"Player1 chose")
draw_sprite(images[p2_index],0,width+width/2,room_height/2);
draw_text(width+width/2-20,room_height/2+135,"Player2 chose")
//draw_sprite_ext(images[p2_index],0,room_width,0,-1,1,0,c_white,1);