package com.parzivail.util.client.screen;

import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class EventCheckboxWidget extends CheckboxWidget
{
	private final Consumer<Boolean> checkChanged;

	public EventCheckboxWidget(int x, int y, int width, int height, Text text, boolean checked, boolean showLabel, Consumer<Boolean> checkChanged)
	{
		super(x, y, width, height, text, checked, showLabel);
		this.checkChanged = checkChanged;
	}

	@Override
	public void onPress()
	{
		super.onPress();
		checkChanged.accept(isChecked());
	}

	public void setChecked(boolean checked)
	{
		if (this.isChecked() == checked)
			return;
		this.onPress();
	}
}
