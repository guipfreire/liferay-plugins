/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.model.impl;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.socialcoding.model.JIRAProject;
import com.liferay.socialcoding.service.JIRAProjectLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class JIRAIssueImpl extends JIRAIssueBaseImpl {

	public JIRAIssueImpl() {
	}

	public String getKey() {
		if (Validator.isNotNull(_key)) {
			return _key;
		}

		try {
			JIRAProject jiraProject =
				JIRAProjectLocalServiceUtil.getJIRAProject(getProjectId());

			_key = jiraProject.getKey() + StringPool.DASH + getIssueNumber();
		}
		catch (Exception e) {
		}

		return _key;
	}

	private String _key;

}