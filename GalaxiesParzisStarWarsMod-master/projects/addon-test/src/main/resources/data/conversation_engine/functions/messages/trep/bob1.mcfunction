# run as the player

# message id: 2

# reset the sucsess scoreboard
scoreboard players set @s CE_suc 0
scoreboard players set @s CE_resend 0

# check if the player came from a valid previous node (to prevent manual use of /trigger)
execute if score @s CE_current_node matches 3 run scoreboard players set @s CE_suc 1

# special case in case the previous node is itself in that case CE_resend of @s is set to 1 (use this to prevent commands that for example give items are executed twice)
execute store success score @s CE_resend if score @s CE_current_node matches 2 run scoreboard players set @s CE_suc 1

    # give the choices
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"Take a look at my store!","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"Buy 1x X-Wing T65B [i](32x Gold Credits)[/i]","color":"#A8DFFF","clickEvent":{"action":"run_command","value":"/trigger CE_trigger set 5"}}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"Buy 1x Warpdrive [i](8x Gold Credits)[/i]","color":"#A8DFFF","clickEvent":{"action":"run_command","value":"/trigger CE_trigger set 4"}}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"Buy 1x Holodrive [i](4x Gold Credits)[/i]","color":"#A8DFFF","clickEvent":{"action":"run_command","value":"/trigger CE_trigger set 6"}}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"Buy 3x Beskar Scraps [i](2x Gold Credits)[/i]","color":"#A8DFFF","clickEvent":{"action":"run_command","value":"/trigger CE_trigger set 7"}}]


    # update the last run node
    execute if score @s CE_suc matches 1 run scoreboard players operation @s CE_current_node = @s CE_trigger
