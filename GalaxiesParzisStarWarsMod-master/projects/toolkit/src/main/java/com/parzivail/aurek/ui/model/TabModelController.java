package com.parzivail.aurek.ui.model;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TabModelController<TModel extends TabModel> implements Collection<TModel>
{
	private final ArrayList<TModel> models = new ArrayList<>();

	public TabModelController()
	{
	}

	@Override
	public int size()
	{
		return models.size();
	}

	@Override
	public boolean isEmpty()
	{
		return models.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return models.contains(o);
	}

	@NotNull
	@Override
	public Iterator<TModel> iterator()
	{
		return models.iterator();
	}

	@NotNull
	@Override
	public Object[] toArray()
	{
		return models.toArray();
	}

	@NotNull
	@Override
	public <T> T[] toArray(@NotNull T[] a)
	{
		return models.toArray(a);
	}

	@Override
	public boolean add(TModel tModel)
	{
		return models.add(tModel);
	}

	private JComponent createEmptyTabContents()
	{
		var p = new JPanel();
		var empty = new Dimension(0, 0);
		p.setSize(empty);
		p.setMinimumSize(empty);
		p.setMaximumSize(empty);
		p.setPreferredSize(empty);
		p.setVisible(false);
		p.setBorder(BorderFactory.createEmptyBorder());
		return p;
	}

	@Override
	public boolean remove(Object o)
	{
		var model = models.indexOf(o);
		if (!models.get(model).tryClose())
			return false;
		return models.remove(o);
	}

	@Override
	public boolean containsAll(@NotNull Collection<?> c)
	{
		return models.containsAll(c);
	}

	@Override
	public boolean addAll(@NotNull Collection<? extends TModel> c)
	{
		return models.addAll(c);
	}

	@Override
	public boolean removeAll(@NotNull Collection<?> c)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean retainAll(@NotNull Collection<?> c)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void clear()
	{
		var discarded = new ArrayList<TModel>();
		for (int i = 0; i < models.size(); i++)
		{
			TModel model = models.get(i);
			if (!model.tryClose())
				continue;
			discarded.add(model);
		}

		this.models.removeAll(discarded);
	}
}
