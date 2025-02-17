/*******************************************************************************
 * Copyright (c) 2021 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package com.redhat.devtools.intellij.quarkus.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuarkusExtensionsModel {
    private final String key;
    private List<QuarkusCategory> categories = new ArrayList<>();

    public QuarkusExtensionsModel(String key, List<QuarkusExtension> extensions) {
        this.key = key;
        Collections.sort(extensions, (e1, e2) -> e1.getOrder() - e2.getOrder());
        Map<String, QuarkusExtension> extensionIds = new HashMap<>();
        final QuarkusCategory[] currentCategory = {null};
        extensions.forEach(e -> {
            if (currentCategory[0] == null || !e.getCategory().equals(currentCategory[0].getName())) {
                currentCategory[0] = new QuarkusCategory(e.getCategory());
                categories.add(currentCategory[0]);
            }
            if (extensionIds.containsKey(e.getId())) {
                currentCategory[0].getExtensions().add(extensionIds.get(e.getId()));
            } else {
                currentCategory[0].getExtensions().add(e);
                extensionIds.put(e.getId(), e);
            }
        });
    }

    public String getKey() {
        return key;
    }

    public List<QuarkusCategory> getCategories() {
        return categories;
    }
}
