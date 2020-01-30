#region //keyborad controller
#macro K_RIGHT		(myPlayer == PLAYER0)?ord("D"):vk_right
#macro K_LEFT		(myPlayer == PLAYER0)?ord("A"):vk_left
#macro K_UP			(myPlayer == PLAYER0)?ord("W"):vk_up
//#macro K_DOWN		(myPlayer ==PLAYER0)?ord("S"):vk_down
#macro K_PUNCH		(myPlayer ==PLAYER0)?ord("Q"):vk_numpad4
#macro K_LOW_PUNCH		(myPlayer ==PLAYER0)?ord("R"):vk_numpad2
#macro K_KICK		(myPlayer ==PLAYER0)?ord("Z"):vk_numpad1
#macro K_BLOCK		(myPlayer ==PLAYER0)?ord("X"):vk_numpad0
#macro K_JUMP_KICK	(myPlayer ==PLAYER0)?ord("E"):vk_numpad7
//#macro K_KICK_HEAVY		(myPlayer ==PLAYER0)?ord("C"):vk_numpad3
#macro K_CROUCH		(myPlayer ==PLAYER0)?ord("S"):vk_down
#macro K_SPECIAL_PRE (myPlayer ==PLAYER0)?ord("F"):vk_numpad5
#macro K_LOW_KICK	(myPlayer ==PLAYER0)?ord("Z"):vk_numpad1
#macro K_SPECIAL_ATTACK (myPlayer ==PLAYER0)?ord("C"):vk_numpad3

#macro C_CONTROLLER			(myPlayer == PLAYER0)?0:1
#macro C_RIGHT_PRESSED		(myPlayer == PLAYER0)?gamepad_button_check(0,gp_padr):gamepad_button_check_pressed(1,gp_padr)
#macro C_LEFT_PRESSED		(myPlayer == PLAYER0)?gamepad_button_check(0,gp_padl):gamepad_button_check_pressed(1,gp_padl)
#macro C_UP_PRESSED			(myPlayer == PLAYER0)?gamepad_button_check_pressed(0,gp_padu):gamepad_button_check_pressed(1,gp_padu)
#macro C_HIGH_PUNCH_PRESSED 	(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_face4):gamepad_button_check_pressed(1,gp_face4)
#macro C_LOW_PUNCH_PRESSED	(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_face3):gamepad_button_check_pressed(1,gp_face3)
#macro C_LOW_KICK_PRESSED	(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_face1):gamepad_button_check_pressed(1,gp_face1)
#macro C_HIGH_KICK_PRESSED	(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_face2):gamepad_button_check_pressed(1,gp_face2)
#macro C_BLOCK_PRESSED		(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_shoulderl):gamepad_button_check_pressed(1,gp_shoulderl)
#macro C_JUMP_KICK_PRESSED	(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_face2):gamepad_button_check_pressed(1,gp_face2)
#macro C_CROUCH_PRESSED		(myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_padd):gamepad_button_check_pressed(1,gp_padd)
#macro C_SPECIAL_ATTACK_PRESSED (myPlayer ==PLAYER0)?gamepad_button_check_pressed(0,gp_shoulderr):gamepad_button_check_pressed(1,gp_shoulderr)


#endregion			



