package com.github.baranbuzluk.user.util;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Helper class for updating the existing object to the desired object
 *
 * @param <T>
 *            Type of object
 */
public class UpdateHelper<T> {
	private final T existingObject;
	private final T desiredObject;

	public UpdateHelper(T existingObject, T desiredObject) {
		this.existingObject = existingObject;
		this.desiredObject = desiredObject;
	}

	public void update() {
		Field[] allFields = desiredObject.getClass().getDeclaredFields();
		Stream.of(allFields).filter(this::shouldUpdate).forEach(this::updateField);
	}

	private boolean shouldUpdate(Field field) {
		Object valueOfFieldOfExistingObject = getValue(field, existingObject);
		Object valueOfFieldOfDesiredObject = getValue(field, desiredObject);
		if (valueOfFieldOfDesiredObject == null) {
			return false;
		}
		return !valueOfFieldOfDesiredObject.equals(valueOfFieldOfExistingObject);
	}

	private void updateField(Field field) {
		Object valueOfFieldOfDesiredObject = getValue(field, desiredObject);
		setValue(field, existingObject, valueOfFieldOfDesiredObject);
	}

	private void setValue(Field field, Object object, Object value) {
		try {
			boolean currentAccess = field.canAccess(object);
			if (!currentAccess) {
				field.setAccessible(true);
			}
			field.set(object, value);
			field.setAccessible(currentAccess);
		} catch (IllegalAccessException ignored) {
		}
	}
	private Object getValue(Field field, Object object) {
		try {
			boolean currentAccess = field.canAccess(object);
			if (!currentAccess) {
				field.setAccessible(true);
			}
			Object value = field.get(object);
			field.setAccessible(currentAccess);
			return value;
		} catch (IllegalAccessException ignored) {
			return null;
		}
	}

}
