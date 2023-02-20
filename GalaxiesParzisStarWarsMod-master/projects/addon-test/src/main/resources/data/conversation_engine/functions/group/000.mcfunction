# run by server

# check wich npc is being talked to.
execute if score CE_mannager trep matches 1 as @p[scores={trep=1}] run function conversation_engine:messages/trep/tick
