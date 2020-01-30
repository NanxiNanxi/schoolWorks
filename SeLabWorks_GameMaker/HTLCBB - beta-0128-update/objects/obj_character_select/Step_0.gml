/// @description Insert description here
// You can write your code in this editor

if(!p1_ready){
	if max(keyboard_check_pressed(ord("D")),0,gamepad_button_check_pressed(0,gp_padl))==1 p1_index++;
	if max(keyboard_check_pressed(ord("A")),0,gamepad_button_check(0,gp_padr))==1 p1_index--;
	if(max(keyboard_check_pressed(vk_space),gamepad_button_check_pressed(0,gp_face3),0)==1) {
		p1_ready = true;
		global.player1_char = p1_index;
	}
}

if(!p2_ready){
	if max(keyboard_check_pressed(vk_right),0,gamepad_button_check_pressed(1,gp_padl))==1 p2_index++;
	if max(keyboard_check_pressed(vk_left),0,gamepad_button_check_pressed(1,gp_padr))==1 p2_index--;
	if max(keyboard_check_pressed(vk_enter),gamepad_button_check_pressed(1,gp_face3),0)==1 {
		p2_ready = true;
		global.player2_char = p2_index;
	}

}

//if(p1_ready and p2_ready) alarm[0]=50;

if p1_index < 0 p1_index = CHAR_NUMBER-1;
if p1_index > 1 p1_index = 0; 
if p2_index < 0 p2_index = CHAR_NUMBER-1;
if p2_index > 1 p2_index = 0; 