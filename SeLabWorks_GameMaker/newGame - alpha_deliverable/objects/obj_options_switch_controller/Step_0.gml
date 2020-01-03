/// @description Insert description here
// You can write your code in this editor
if max(keyboard_check_pressed(ord("W")), 0 ,keyboard_check_pressed(vk_up))==1{
	current_index--;
	if current_index <0 current_index = array_length_1d(controller_string)-1
}

if  max(keyboard_check_pressed(ord("S")), 0 ,keyboard_check_pressed(vk_down))==1{
	current_index++;
	if current_index > array_length_1d(controller_string)-1 current_index = 0;
}

if max(keyboard_check_pressed(vk_enter), 0,gamepad_button_check_pressed(0, gp_start)) ==1 
	switch (current_index){
		case 0:
			controller = CON_KEYBOARD;
		break
		
		case 1:
			controller = CON_GAME_PAD;
		break
		
		case 2:
			room_goto(rm_main_menu);
		break
			
	
	}