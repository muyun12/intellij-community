// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.execution.services;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.ui.AnimatedIcon;
import com.intellij.util.messages.Topic;
import org.jetbrains.annotations.ApiStatus;

import javax.swing.*;

@ApiStatus.Experimental
public interface ServiceViewManager {
  Topic<ServiceViewListener> SERVICE_VIEW_TOPIC =
    Topic.create("services tool window", ServiceViewListener.class, Topic.BroadcastDirection.TO_PARENT);
  Icon RUNNING_ICON = new AnimatedIcon.Default();
  Key<Boolean> SERVICE_VIEW_MASTER_COMPONENT = Key.create("SERVICE_VIEW_MASTER_COMPONENT");

  void selectNode(Object node);

  void contentChanged(boolean withStructure);

  static ServiceViewManager getInstance(Project project) {
    return ServiceManager.getService(project, ServiceViewManager.class);
  }
  interface ServiceViewListener {
  }
}
