package ringui.dialog

import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.RProps
import ringui.REventFunc
import ringui.island.IslandContent
import ringui.island.IslandContentProps
import ringui.island.IslandHeader
import ringui.island.IslandHeaderProps

interface DialogProps : RProps {
    var className: String
    var contentClassName: String
    var show: Boolean
    var showCloseButton: Boolean
    var onOverlayClick: () -> Unit
    var onEscPress: REventFunc
    var onCloseClick: REventFunc
    // onCloseAttempt is a common callback for ESC pressing and overlay clicking.
    // Use it if you don't need different behaviors for this cases.
    var onCloseAttempt: REventFunc
    // focusTrap may break popups inside dialog, so use it carefully
    var trapFocus: Boolean
    var autoFocusFirst: Boolean
}

fun RBuilder.dialog(show: Boolean, className: String? = null, contentClassName: String? = null, block: RElementBuilder<DialogProps>.() -> Unit = {}) = child(Dialog::class) {
    attrs.show = show
    className?.let { attrs.className = className }
    contentClassName?.let { attrs.contentClassName = contentClassName }

    this.block()
}

fun RBuilder.dialogHeader(title: String, block: RHandler<IslandHeaderProps>) = child(IslandHeader::class, block)

fun RBuilder.dialogContent(title: String, block: RHandler<IslandContentProps>) = child(IslandContent::class, block)