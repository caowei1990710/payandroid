package com.codeboy.qianghongbao.webview;

import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by snsoft on 26/7/2017.
 */
public class Utterance {
    /**
     * Key for obtaining the queuing meta-data property.
     */
    public static final String KEY_METADATA_QUEUING = "queuing";

    /**
     * Key for specifying utterance group
     */
    public static final String KEY_UTTERANCE_GROUP = "utterance_group";

    /**
     * Key for obtaining the earcon rate meta-data property.
     */
    public static final String KEY_METADATA_EARCON_RATE = "earcon_rate";

    /**
     * Key for obtaining the earcon volume meta-data property.
     */
    public static final String KEY_METADATA_EARCON_VOLUME = "earcon_volume";

    /**
     * Key for obtaining the speech parameters meta-data property. Must contain
     * a {@link Bundle}.
     */
    public static final String KEY_METADATA_SPEECH_PARAMS = "speech_params";

    /**
     * Key for obtaining the speech flags meta-data property.
     */
    public static final String KEY_METADATA_SPEECH_FLAGS = "speech_flags";

    /**
     * Meta-data of how the utterance should be spoken.
     */
    private final Bundle mMetadata = new Bundle();

    /**
     * The list of text to speak.
     */
    private final List<CharSequence> mSpokenFeedback = new LinkedList<>();

    /**
     * The list of auditory feedback identifiers to play.
     */
    private final Set<Integer> mAuditoryFeedback = new HashSet<>();

    /**
     * The list of haptic feedback identifiers to play.
     */
    private final Set<Integer> mHapticFeedback = new HashSet<>();

    public Utterance() {
    }

    /**
     * Adds spoken feedback to this utterance.
     *
     * @param text The text to speak.
     */
    public void addSpoken(CharSequence text) {
        mSpokenFeedback.add(text);
    }

    public void addSpokenFlag(int flag) {
        final int flags = mMetadata.getInt(KEY_METADATA_SPEECH_FLAGS, 0);
        mMetadata.putInt(KEY_METADATA_SPEECH_FLAGS, flags | flag);
    }

    /**
     * Adds auditory feedback to this utterance.
     *
     * @param id The value associated with the auditory feedback to play.
     */
    public void addAuditory(int id) {
        mAuditoryFeedback.add(id);
    }

    /**
     * Adds auditory feedback to this utterance.
     *
     * @param ids A collection of identifiers associated with the auditory
     *            feedback to play.
     */
    public void addAllAuditory(Collection<? extends Integer> ids) {
        mAuditoryFeedback.addAll(ids);
    }

    /**
     * Adds haptic feedback to this utterance.
     *
     * @param id The value associated with the haptic feedback to play.
     */
    public void addHaptic(int id) {
        mHapticFeedback.add(id);
    }

    /**
     * Adds haptic feedback to this utterance.
     *
     * @param ids A collection of identifiers associated with the haptic
     *            feedback to play.
     */
    public void addAllHaptic(Collection<? extends Integer> ids) {
        mHapticFeedback.addAll(ids);
    }

    /**
     * Gets the meta-data of this utterance.
     *
     * @return The utterance meta-data.
     */
    public Bundle getMetadata() {
        return mMetadata;
    }

    /**
     * @return An unmodifiable list of spoken text attached to this utterance.
     */
    public List<CharSequence> getSpoken() {
        return Collections.unmodifiableList(mSpokenFeedback);
    }

    /**
     * @return An unmodifiable set of auditory feedback identifiers attached to
     * this utterance.
     */
    public Set<Integer> getAuditory() {
        return Collections.unmodifiableSet(mAuditoryFeedback);
    }

    /**
     * @return An unmodifiable set of haptic feedback identifiers attached to
     * this utterance.
     */
    public Set<Integer> getHaptic() {
        return Collections.unmodifiableSet(mHapticFeedback);
    }

    @Override
    public String toString() {
        return "Text:{" + mSpokenFeedback + "}, Metadata:" + mMetadata;
    }

}
