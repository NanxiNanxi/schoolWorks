/// @description Insert description here
// You can write your code in this editor

if max(keyboard_check_pressed(ord("W")), 0 ,keyboard_check_pressed(vk_up))==1{
	current_index--;
	if current_index <0 current_index = array_length_1d(menu)-1
}

if  max(keyboard_check_pressed(ord("S")), 0 ,keyboard_check_pressed(vk_down))==1{
	current_index++;
	if current_index > array_length_1d(menu)-1 current_index = 0;
}



if keyboard_check_pressed(vk_enter){
	switch (current_index){
		case 0:
			room_goto(rm_character_select);
		break
		
		case 1:
			
			room_goto(rm_options);
		break;
		
		case 2:
			room_goto(rm_choose_stage)
		break
		
		case 3:
		
			room_goto(rm_credit)
		break
		case 4:
			game_end();
		break
		
		
	}
}

